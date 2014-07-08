package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.custom.PplaWorkOrderServiceCustom;
import com.ppla.core.dto.PplaWorkOrderInfo;

/**
 * @author Mark
 */
public class PplaWorkOrderServiceCustomImpl implements PplaWorkOrderServiceCustom {

    @Autowired
    private PplaWorkOrderService workOrders;

    @Autowired
    private Mapper mapper;

    private PplaWorkOrderInfo toDto(PplaWorkOrder pplaWorkOrder) {
        return mapper.map(pplaWorkOrder, PplaWorkOrderInfo.class);
    }

    @Override
    public List<PplaWorkOrderInfo> assembleBySalesOrder(PplaSalesOrder salesOrder) {
        List<PplaWorkOrder> orders = workOrders.findBySalesOrder(salesOrder);
        List<PplaWorkOrderInfo> dtos = Lists.newArrayList();
        for (PplaWorkOrder order : orders) {
            dtos.add(toDto(order));
        }
        return dtos;
    }

    @Override
    public PplaWorkOrderInfo save(PplaWorkOrderInfo workOrder) {
        // TODO Auto-generated method stub
        return null;
    }
}
