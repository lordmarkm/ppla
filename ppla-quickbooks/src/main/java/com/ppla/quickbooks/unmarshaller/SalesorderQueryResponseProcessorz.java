package com.ppla.quickbooks.unmarshaller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baldy.commons.models.proper.Name;
import com.google.common.collect.Lists;
import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaPerson;
import com.ppla.app.models.PplaProduct;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.PplaProductService;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.entity.generated.SalesOrderLineRet;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRsType;
import com.ppla.quickbooks.entity.generated.SalesOrderRet;
import com.ppla.quickbooks.reference.PplaInventoryType;
import com.ppla.quickbooks.service.InventoryItemService;

/**
 * @author markm
 */
@Service
public class SalesorderQueryResponseProcessorz {

    private static final Logger LOG = LoggerFactory.getLogger(SalesorderQueryResponseProcessorz.class);
    private static final String TRUE = "true";

    @Autowired
    private PplaPersonService personService;

    @Autowired
    private PplaSalesOrderService soService;

    @Autowired
    private PplaProductService productService;

    @Autowired
    private InventoryItemService inventoryService;

    public void processSalesOrderQueryResponse(SalesOrderQueryRsType salesOrderQueryRsType) {
        List<SalesOrderRet> salesOrders = salesOrderQueryRsType.getSalesOrderRet();
        for (SalesOrderRet salesOrder : salesOrders) {
            processSalesOrder(salesOrder);
        }
    }

    private void processSalesOrder(SalesOrderRet salesOrderRet) {
        PplaSalesOrder existing = soService.findByTxnNumber(salesOrderRet.getTxnNumber());
        PplaSalesOrder so;

        if (null != existing) {
            LOG.warn("Updating existing sales order. txn#={}", existing.getTxnNumber());
            so = existing;
        } else {
            //Ignore new sales orders that are already closed
            if (TRUE.equalsIgnoreCase(salesOrderRet.getIsManuallyClosed())
                    || TRUE.equalsIgnoreCase(salesOrderRet.getIsFullyInvoiced())) {
                LOG.debug("Ignoring closed sales order.");
                return;
            }

            so = new PplaSalesOrder();
            so.setDateCreated(DateTime.now());
            so.setTrackingNo(RandomStringUtils.randomAlphanumeric(5));
            so.setTxnNumber(salesOrderRet.getTxnNumber());
        }

        so.setEditSequence(salesOrderRet.getEditSequence());
        so.setTimeModified(DateTime.now());

        //Shipping address
        if (null != salesOrderRet.getShipAddressBlock()) {
            so.setShipTo(salesOrderRet.getShipAddressBlock().getAddr1());
        }

        //Customer
        PplaPerson customer = personService.findByListId(salesOrderRet.getCustomerRef().getListID());
        if (null == customer) {
            Name name = new Name();
            name.setSurname(salesOrderRet.getCustomerRef().getFullName());
            name.setGivenName("");
            customer = new PplaPerson();
            customer.setName(name);
            customer.setListId(salesOrderRet.getCustomerRef().getListID());
            personService.save(customer);
        }
        so.setCustomer(customer);

        //Items
        List<Object> inventoryElements = salesOrderRet.getSalesOrderLineRetOrSalesOrderLineGroupRet();
        List<PplaOrderItem> orderItems = Lists.newArrayList();
        for (Object inventoryElement : inventoryElements) {
            if (inventoryElement instanceof SalesOrderLineRet) {
                PplaOrderItem item = processSalesOrderLineRet((SalesOrderLineRet) inventoryElement);
                if (null != item) {
                    item.setSalesOrder(so);
                    orderItems.add(item);
                }
            }
        }
        so.setItems(orderItems);

        LOG.debug("Successfully created sales order. Saving. Txn#={}", so.getTxnNumber());
        soService.save(so);
    }

    private PplaOrderItem processSalesOrderLineRet(SalesOrderLineRet inventoryElement) {
        if (null == inventoryElement.getItemRef() || null == inventoryElement.getItemRef().getListID()) {
            LOG.warn("Sales order item has no product attached or product has no line id. Skipping.");
            return null;
        }
        String productListId = inventoryElement.getItemRef().getListID();
        LOG.debug("Trying to find product by list id. id={}", productListId);
        PplaProduct product = productService.findByInventoryItemListId(productListId);
        if (null == product) {
            LOG.warn("Product not found! Trying to create product from inventory.");

            InventoryItem ii = inventoryService.findByListId(productListId);
            if (null != ii) {
                inventoryService.createInstanceAs(ii, PplaInventoryType.PRODUCT);
                product = productService.findByInventoryItemListId(productListId);
                if (null == product) {
                    LOG.error("Failed to create product from inventory item! Skipping product.");
                    return null;
                }
            } else {
                InventoryItem newInventoryItem = new InventoryItem();
                newInventoryItem.setListId(productListId);
                newInventoryItem.setDescription(inventoryElement.getDesc());
                newInventoryItem.setName(inventoryElement.getItemRef().getFullName());
                newInventoryItem.setType(PplaInventoryType.PRODUCT);
                newInventoryItem.setTimeModified(DateTime.now());
                inventoryService.save(newInventoryItem);
                inventoryService.createInstanceAs(newInventoryItem, PplaInventoryType.PRODUCT);
                product = productService.findByInventoryItemListId(productListId);
            }
        } else {
            LOG.debug("Found product. product={}", product.getName());
        }

        PplaOrderItem oi = new PplaOrderItem();
        oi.setQuantity(new BigDecimal(inventoryElement.getQuantity()));
        oi.setTxnLineId(inventoryElement.getTxnLineID());
        oi.setProduct(product);

        return oi;
    }

}
