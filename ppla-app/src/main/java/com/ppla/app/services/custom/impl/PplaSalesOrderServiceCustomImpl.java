package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.custom.PplaSalesOrderServiceCustom;
import com.ppla.core.dto.PplaSalesOrderInfo;
import com.ppla.core.dto.PplaWorkOrderInfo;

/**
 * @author Mark
 */
public class PplaSalesOrderServiceCustomImpl implements PplaSalesOrderServiceCustom {

    @Autowired
    private PplaSalesOrderService service;

    @Autowired
    private PplaWorkOrderService workOrdersRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public PplaSalesOrderInfo assemble(String trackingNo) {
        PplaSalesOrder salesOrder = service.findByTrackingNo(trackingNo);
        PplaSalesOrderInfo dto = toDto(salesOrder);

        List<PplaWorkOrderInfo> workOrders = workOrdersRepo.assembleBySalesOrder(salesOrder);
        dto.setWorkOrders(workOrders);

        return dto;
    }

    private PplaSalesOrderInfo toDto(PplaSalesOrder salesOrder) {
        return mapper.map(salesOrder, PplaSalesOrderInfo.class);
    }

}
