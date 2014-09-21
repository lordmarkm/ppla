package com.ppla.quickbooks.service.custom;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.service.InventoryItemService;

/**
 * @author Mark
 */
public class InventoryItemServiceCustomImpl implements InventoryItemServiceCustom {

    private static final String longTimeAgo = "1987-03-04T00:00:00+08:00";

    @Autowired
    private InventoryItemService service;

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

}
