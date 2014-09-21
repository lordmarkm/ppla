package com.ppla.quickbooks.service;

import com.ppla.app.servicebase.BasePplaService;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.service.custom.InventoryItemServiceCustom;

/**
 * @author Mark
 */
public interface InventoryItemService extends BasePplaService<InventoryItem, Long>, InventoryItemServiceCustom {

}
