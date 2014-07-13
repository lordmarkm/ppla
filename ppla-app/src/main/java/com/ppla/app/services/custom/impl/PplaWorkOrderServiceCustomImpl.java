package com.ppla.app.services.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.custom.PplaWorkOrderServiceCustom;
import com.ppla.core.dto.PplaWorkOrderInfo;

/**
 * @author Mark
 */
public class PplaWorkOrderServiceCustomImpl extends MappingService<PplaWorkOrder, PplaWorkOrderInfo>
    implements PplaWorkOrderServiceCustom {

    @Autowired
    private PplaWorkOrderService workOrders;

    @Autowired
    private PplaOrderItemService orderItemService;

    public PplaWorkOrderServiceCustomImpl() {
        super(PplaWorkOrder.class, PplaWorkOrderInfo.class);
    }

    @Override
    public PplaWorkOrderInfo save(PplaWorkOrderInfo workOrderInfo) {
        return toDto(workOrders.save(toEntity(workOrderInfo)));
    }

    @Override
    public PplaWorkOrderInfo createNew(Long orderItemId,
            PplaWorkOrderInfo workOrder) {

        PplaWorkOrder saved = workOrders.saveAndFlush(toEntity(workOrder));

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
}
