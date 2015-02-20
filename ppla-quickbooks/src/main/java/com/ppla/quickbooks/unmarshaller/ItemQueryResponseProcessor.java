package com.ppla.quickbooks.unmarshaller;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.entity.generated.ItemInventoryRet;
import com.ppla.quickbooks.entity.generated.ItemQueryRsType;
import com.ppla.quickbooks.service.InventoryItemService;

/**
 * @author Mark
 */
@Service
public class ItemQueryResponseProcessor {

    private static Logger LOG = LoggerFactory.getLogger(ItemQueryResponseProcessor.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private InventoryItemService service;

    public void processItemQueryResponse(ItemQueryRsType itemQueryRsType) {
        List<Object> items = itemQueryRsType.getItemServiceRetOrItemNonInventoryRetOrItemOtherChargeRet();
        for (Object item : items) {
            LOG.debug("Processing item. class={}", item.getClass());
            if (item instanceof ItemInventoryRet) {
                processItemInventoryRet((ItemInventoryRet) item);
            }
        }
    }

    private void processItemInventoryRet(ItemInventoryRet item) {
        InventoryItem inventoryItem = service.findByListId(item.getListID());
        if (null != inventoryItem) {
            //If editsequence is the same, this item has been saved before with no changes. We trust
            //QB to manage this sequence.
            if (ObjectUtils.equals(item.getEditSequence(), inventoryItem.getEditSequence())) {
                LOG.debug("Skipping item with existing edit sequence");
                return;
            }
            mapper.map(item, inventoryItem);
        } else {
            inventoryItem = mapper.map(item, InventoryItem.class);
            if (null == inventoryItem.getUnitOfMeasurement()) {
                inventoryItem.setUnitOfMeasurement("Kg");
            }
        }
        LOG.debug("Saving inventory item. List id={}", item.getListID());
        service.save(inventoryItem);
    }

}
