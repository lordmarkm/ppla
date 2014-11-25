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
import com.ppla.quickbooks.entity.generated.SalesOrderLineRet;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRsType;
import com.ppla.quickbooks.entity.generated.SalesOrderRet;

/**
 * @author markm
 */
@Service
public class SalesorderQueryResponseProcessorz {

    private static final Logger LOG = LoggerFactory.getLogger(SalesorderQueryResponseProcessorz.class);

    @Autowired
    private PplaPersonService personService;

    @Autowired
    private PplaSalesOrderService soService;

    @Autowired
    private PplaProductService productService;

    public void processSalesOrderQueryResponse(SalesOrderQueryRsType salesOrderQueryRsType) {
        List<SalesOrderRet> salesOrders = salesOrderQueryRsType.getSalesOrderRet();
        for (SalesOrderRet salesOrder : salesOrders) {
            processSalesOrder(salesOrder);
        }
    }

    private void processSalesOrder(SalesOrderRet salesOrderRet) {
        PplaSalesOrder existing = soService.findByTxnNumber(salesOrderRet.getTxnNumber());
        if (null != existing) {
            LOG.warn("Ignoring already existing sales order. txn#={}", existing.getTxnNumber());
            return;
        }

        PplaSalesOrder so = new PplaSalesOrder();
        so.setDateCreated(DateTime.now());
        so.setEditSequence(salesOrderRet.getEditSequence());
        so.setTrackingNo(RandomStringUtils.random(5));
        so.setTxnNumber(salesOrderRet.getTxnNumber());

        //Shipping address
        if (null != salesOrderRet.getShipAddressBlock()) {
            so.setShipTo(salesOrderRet.getShipAddressBlock().getAddr1());
        }

        //Customer
        PplaPerson customer = personService.findByListId(salesOrderRet.getCustomerRef().getListID());
        if (null == customer) {
            Name name = new Name();
            name.setSurname(salesOrderRet.getCustomerRef().getFullName());
            customer = new PplaPerson();
            customer.setName(name);
            personService.save(customer);
        }
        so.setCustomer(customer);

        //Items
        List<Object> inventoryElements = salesOrderRet.getSalesOrderLineRetOrSalesOrderLineGroupRet();
        List<PplaOrderItem> orderItems = Lists.newArrayList();
        for (Object inventoryElement : inventoryElements) {
            if (inventoryElement instanceof SalesOrderLineRet) {
                PplaOrderItem item = processSalesOrderLineRet((SalesOrderLineRet) inventoryElement);
                item.setSalesOrder(so);
                if (null != item) {
                    orderItems.add(item);
                }
            }
        }
        so.setItems(orderItems);

        LOG.debug("Successfully created sales order. Saving. Txn#={}", so.getTxnNumber());
        soService.save(so);
    }

    private PplaOrderItem processSalesOrderLineRet(SalesOrderLineRet inventoryElement) {
        String productListId = inventoryElement.getItemRef().getListID();
        LOG.debug("Trying to find product by list id. id={}", productListId);
        PplaProduct product = productService.findByInventoryItemListId(productListId);
        if (null == product) {
            LOG.warn("Product not found!");
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
