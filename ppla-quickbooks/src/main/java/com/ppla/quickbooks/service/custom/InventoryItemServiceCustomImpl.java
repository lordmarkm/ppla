package com.ppla.quickbooks.service.custom;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.core.dto.PplaOrderItemInfo;
import com.ppla.core.dto.PplaWorkOrderInfo;
import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.service.InventoryItemService;
import com.tyrael.commons.mapper.dto.PageInfo;

/**
 * @author Mark
 */
public class InventoryItemServiceCustomImpl implements InventoryItemServiceCustom {

    private static final String longTimeAgo = "1987-03-04T00:00:00+08:00";

    @Autowired
    private InventoryItemService service;

    @Autowired
    private Mapper mapper;

    @Override
    public String getLastModifiedDate() {
        String lastModifiedDate = null;

        PageRequest page = new PageRequest(0, 1, Direction.DESC, "timeModified");
        List<InventoryItem> itemz = service.findAll(page).getContent();
        if (itemz.size() == 0) {
            lastModifiedDate = longTimeAgo;
        } else {
            InventoryItem lastModifiedItem = itemz.get(0);
            lastModifiedDate = ObjectUtils.toString(lastModifiedItem.getTimeModified());
        }

        return lastModifiedDate;
    }

    @Override
    public PageInfo<InventoryItemInfo> pageInfo(PageRequest pageRequest) {
        Page<InventoryItem> results = service.findAll(pageRequest);
        List<InventoryItemInfo> infos = Lists.newArrayList();
        for (InventoryItem wo : results) {
            InventoryItemInfo woInfo = mapper.map(wo, InventoryItemInfo.class);
            infos.add(woInfo);
        }

        PageInfo<InventoryItemInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(infos);
        pageResponse.setTotal(results.getTotalElements());
        return pageResponse;
    }

}
