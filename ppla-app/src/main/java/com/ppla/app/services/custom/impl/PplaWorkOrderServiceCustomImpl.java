package com.ppla.app.services.custom.impl;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.QPplaOrderItem;
import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.ProcessMaterialStackService;
import com.ppla.app.services.custom.PplaWorkOrderServiceCustom;
import com.ppla.core.dto.PplaOrderItemInfo;
import com.ppla.core.dto.PplaWorkOrderInfo;
import com.tyrael.commons.dto.PageInfo;
import com.tyrael.commons.mapper.service.MappingService;

/**
 * @author Mark
 */
public class PplaWorkOrderServiceCustomImpl extends MappingService<PplaWorkOrder, PplaWorkOrderInfo>
    implements PplaWorkOrderServiceCustom {

    private static Logger LOG = LoggerFactory.getLogger(PplaWorkOrderServiceCustomImpl.class);

    @Autowired
    private PplaWorkOrderService workOrders;

    @Autowired
    private PplaOrderItemService orderItemService;

    @Autowired
    private ProcessMaterialStackService procMatStackService;

    @Override
    public PplaWorkOrderInfo findInfoByTrackingNo(String trackingNo) {
        return toDto(workOrders.findByTrackingNo(trackingNo));
    }

    @Override
    public PplaWorkOrderInfo save(PplaWorkOrderInfo workOrderInfo) {
        return toDto(workOrders.save(toEntity(workOrderInfo)));
    }

    @Override
    public PplaWorkOrderInfo createNew(Long orderItemId,
            PplaWorkOrderInfo workOrderInfo) {

        PplaWorkOrder workOrder = toEntity(workOrderInfo);
        workOrder.setStatus(PplaWorkOrder.STATUS_OPEN);
        workOrder.setDateCreated(DateTime.now());
        workOrder.setTrackingNo(RandomStringUtils.randomAlphanumeric(6));
        PplaWorkOrder saved = workOrders.saveAndFlush(workOrder);

        //Save order item relation
        PplaOrderItem orderItem = orderItemService.findOne(orderItemId);
        orderItem.setWorkOrder(saved);
        orderItemService.save(orderItem);

        return toDto(saved);
    }

    @Override
    public PplaWorkOrderInfo attach(Long orderItemId, String trackingNo) {

        PplaWorkOrder workOrder = workOrders.findByTrackingNo(trackingNo);
        PplaOrderItem orderItem = orderItemService.findOne(orderItemId);

        orderItem.setWorkOrder(workOrder);
        orderItemService.save(orderItem);

        return toDto(workOrder);
    }

    @Override
    public List<PplaWorkOrderInfo> findOpenWithSameProductInfo(Long orderItemId) {

        PplaOrderItem orderItem = orderItemService.findOne(orderItemId);

        //Query = product = orderItem.product & workorder.status != closed
        List<PplaOrderItem> orderItemsWithSameProduct = (List<PplaOrderItem>) orderItemService.findAll(
            QPplaOrderItem.pplaOrderItem.product.eq(orderItem.getProduct())
                .and(QPplaOrderItem.pplaOrderItem.workOrder.status.ne(PplaWorkOrder.STATUS_CLOSED)));

        List<PplaWorkOrderInfo> attachables = Lists.newArrayList();
        for (PplaOrderItem orderItemWithSameProduct : orderItemsWithSameProduct) {
            if (orderItemWithSameProduct.getId() == orderItemId) {
                continue;
            }
            attachables.add(toDto(orderItemWithSameProduct.getWorkOrder()));
        }
        return attachables;
    }

    @Override
    public PageInfo<PplaWorkOrderInfo> page(PageRequest pageRequest) {
        return page(pageRequest, true);
    }

    @Override
    public PageInfo<PplaWorkOrderInfo> page(PageRequest pageRequest, Boolean includeClosed) {
        Page<PplaWorkOrder> results = null;
        if (includeClosed != null && !includeClosed) {
            LOG.debug("Ignoring closed work orders.");
            results = workOrders.findByStatus(PplaWorkOrder.STATUS_OPEN, pageRequest);
        } else {
            results = workOrders.findAll(pageRequest);
        }

        List<PplaWorkOrderInfo> infos = Lists.newArrayList();
        for (PplaWorkOrder wo : results) {
            
            PplaWorkOrderInfo woInfo = toDto(wo);
            List<PplaOrderItemInfo> items = orderItemService.findAttachedInfo(wo.getTrackingNo());
            woInfo.setOrderItems(items);

            infos.add(woInfo);
        }

        PageInfo<PplaWorkOrderInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(infos);
        pageResponse.setTotal(results.getTotalElements());
        return pageResponse;
    }

    @Override
    public PplaWorkOrderInfo close(String trackingNo) {
        PplaWorkOrder workOrder = workOrders.findByTrackingNo(trackingNo);
        workOrder.setDateCompleted(DateTime.now());
        workOrder.setStatus(PplaWorkOrder.STATUS_CLOSED);
        return toDto(workOrders.save(workOrder));
    }

    @Override
    public PplaWorkOrderInfo findInfoByMaterialTag(String tag) {
        ProcessMaterialStack stack = procMatStackService.findByTag(tag);
        if (null == stack) {
            return null;
        }
        String woTrackingNo = stack.getWorkorderTrackingNo();
        return toDto(workOrders.findByTrackingNo(woTrackingNo));
    }

}
