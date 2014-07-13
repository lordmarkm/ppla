package com.ppla.app.services.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.custom.PplaOrderItemServiceCustom;
import com.ppla.core.dto.PplaOrderItemInfo;

/**
 * @author Mark
 */
public class PplaOrderItemServiceCustomImpl extends MappingService<PplaOrderItem, PplaOrderItemInfo>
    implements PplaOrderItemServiceCustom {

    public PplaOrderItemServiceCustomImpl() {
        super(PplaOrderItem.class, PplaOrderItemInfo.class);
    }

    @Autowired
    private PplaOrderItemService service;

    @Override
    public PplaOrderItemInfo findOneInfo(Long id) {
        return toDto(service.findOne(id));
    }
}
