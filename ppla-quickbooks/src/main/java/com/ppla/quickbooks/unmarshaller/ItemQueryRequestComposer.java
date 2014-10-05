package com.ppla.quickbooks.unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppla.quickbooks.entity.generated.ItemQueryRqType;
import com.ppla.quickbooks.service.InventoryItemService;

/**
 * @author markm
 */
@Service
public class ItemQueryRequestComposer {

    private static Logger LOG = LoggerFactory.getLogger(ItemQueryRequestComposer.class);

    @Autowired
    private InventoryItemService service;

    public ItemQueryRqType createItemQuery() {
        ItemQueryRqType itemQuery = new ItemQueryRqType();
        itemQuery.setFromModifiedDate(service.getLastModifiedDate());
        //itemQuery.setFromModifiedDate("2014-09-19T16:57:59+08:00");
        itemQuery.setRequestID("SXRlbVF1ZXJ5fDEyMA==");
        itemQuery.getOwnerID().add("0");

        LOG.debug("Querying from last modified date={}", itemQuery.getFromModifiedDate());

        return itemQuery;
    }

}
