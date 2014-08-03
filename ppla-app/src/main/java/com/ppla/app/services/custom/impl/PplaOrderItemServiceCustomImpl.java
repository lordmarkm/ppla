package com.ppla.app.services.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.QPplaOrderItem;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.custom.PplaOrderItemServiceCustom;
import com.ppla.core.dto.PplaOrderItemInfo;
import com.tyrael.commons.mapper.service.MappingService;

/**
 * @author Mark
 */
public class PplaOrderItemServiceCustomImpl extends MappingService<PplaOrderItem, PplaOrderItemInfo>
    implements PplaOrderItemServiceCustom {

    @Autowired
    private PplaOrderItemService service;

    @Override
    public PplaOrderItemInfo findOneInfo(Long id) {
        return toDto(service.findOne(id));
    }

    @Override
    public List<PplaOrderItemInfo> findAttachedInfo(String trackingNo) {
        Iterable<PplaOrderItem> orderItems = service.findAll(QPplaOrderItem.pplaOrderItem.workOrder.trackingNo.eq(trackingNo));
        return toDto(orderItems);
    }
}
