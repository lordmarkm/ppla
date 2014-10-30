package com.ppla.quickbooks.service.custom;

import org.springframework.data.domain.PageRequest;

import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.reference.PplaInventoryType;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author Mark
 */
public interface InventoryItemServiceCustom {

    String getLastModifiedDate();
    PageInfo<InventoryItemInfo> pageInfo(PageRequest pageRequest);
    InventoryItemInfo saveInfo(InventoryItemInfo item);

    /**
     * WARNING: Will not clear other types.
     */
    InventoryItem createInstanceAs(InventoryItem item, PplaInventoryType type);
}
