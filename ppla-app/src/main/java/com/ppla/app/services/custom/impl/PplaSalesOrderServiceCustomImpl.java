package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.app.services.custom.PplaSalesOrderServiceCustom;
import com.ppla.core.dto.PplaSalesOrderInfo;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author Mark
 */
public class PplaSalesOrderServiceCustomImpl implements PplaSalesOrderServiceCustom {

    @Autowired
    private Mapper mapper;

    @Autowired
    private PplaSalesOrderService service;

    private PplaSalesOrderInfo toDto(PplaSalesOrder salesOrder) {
        return mapper.map(salesOrder, PplaSalesOrderInfo.class);
    }

    @Override
    public PplaSalesOrderInfo findInfoByTrackingNo(String trackingNo) {
        PplaSalesOrder salesOrder = service.findByTrackingNo(trackingNo);
        PplaSalesOrderInfo salesOrderInfo = toDto(salesOrder);

        return salesOrderInfo;
    }

    @Override
    public PageInfo<PplaSalesOrderInfo> page(Pageable page) {
        Page<PplaSalesOrder> results = service.findAll(page);
        List<PplaSalesOrderInfo> infos = Lists.newArrayList();
        for (PplaSalesOrder order : results) {
            infos.add(mapper.map(order, PplaSalesOrderInfo.class));
        }

        PageInfo<PplaSalesOrderInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(infos);
        pageResponse.setTotal(results.getTotalElements());
        return pageResponse;
    }

}
