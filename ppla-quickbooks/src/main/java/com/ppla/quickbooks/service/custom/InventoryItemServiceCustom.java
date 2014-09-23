package com.ppla.quickbooks.service.custom;

import org.springframework.data.domain.PageRequest;

import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

/**
 * @author Mark
 */
public interface InventoryItemServiceCustom {

    String getLastModifiedDate();
    PageInfo<InventoryItemInfo> pageInfo(PageRequest pageRequest);

}
