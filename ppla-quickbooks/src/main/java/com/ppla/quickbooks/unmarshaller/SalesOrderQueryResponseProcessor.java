package com.ppla.quickbooks.unmarshaller;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.dozer.Mapper;
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
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.PplaProductService;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.app.util.BigDecimalUtil;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.entity.generated.SalesOrderLineRet;
import com.ppla.quickbooks.entity.generated.SalesOrderQueryRsType;
import com.ppla.quickbooks.entity.generated.SalesOrderRet;
import com.ppla.quickbooks.entity.generated.ShipAddress;
import com.ppla.quickbooks.reference.PplaInventoryType;
import com.ppla.quickbooks.service.InventoryItemService;

/**
 * @author markm
 */
@Service
public class SalesOrderQueryResponseProcessor {

    private static Logger LOG = LoggerFactory.getLogger(SalesOrderQueryResponseProcessor.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private PplaSalesOrderService service;

    @Autowired
    private PplaProductService productService;

    @Autowired
    private InventoryItemService inventoryItemService;

    @Autowired
    private PplaOrderItemService orderItemService;

    @Autowired
    private PplaPersonService persons;

    public void processSalesOrderQueryResponse(SalesOrderQueryRsType o) {
        LOG.debug("Processing sales order query rs.");
        for (SalesOrderRet salesOrderRet : o.getSalesOrderRet()) {
            processSalesOrderRet(salesOrderRet);
        }
    }

    private void processSalesOrderRet(SalesOrderRet salesOrderRet) {
        LOG.debug("Processing sales order ret");
        LOG.debug("customer={}", salesOrderRet.getCustomerRef().getFullName());
        LOG.debug("date={}", salesOrderRet.getTxnDate());

        PplaSalesOrder salesOrder = service.findByTxnNumber(salesOrderRet.getTxnNumber());
        if (null != salesOrder && ObjectUtils.equals(salesOrderRet.getEditSequence(), salesOrder.getEditSequence())) {
            LOG.debug("Skipping repeated edit sequence. es={}", salesOrder.getEditSequence());
            return;
        }

        //This will map:
        // 1. txnNumber
        // 2. editSequence
        if (null != salesOrder) {
            mapper.map(salesOrderRet, salesOrder);
        } else {
            salesOrder= mapper.map(salesOrderRet, PplaSalesOrder.class);

            //Set tracking no for new sales order
            String candidateTrackingNo = RandomStringUtils.randomAlphanumeric(6);
            while (null != service.findByTrackingNo(candidateTrackingNo)) {
                candidateTrackingNo = RandomStringUtils.randomAlphanumeric(6);
            }
            salesOrder.setTrackingNo(candidateTrackingNo);
        }

        //Set modified date
        salesOrder.setTimeModified(DateTime.now());

        //Set customer
        PplaPerson customer = persons.findByListId(salesOrderRet.getCustomerRef().getListID());
        if (null == customer) {
            customer = createCustomer(salesOrderRet);
        }
        salesOrder.setCustomer(customer);

        //Set shipping address
        ShipAddress shipAddress = salesOrderRet.getShipAddress();
        if (null != shipAddress) {
            salesOrder.setShipTo(shipAddress.getAddr1());
        }

        //Save initially so we can persist order items
        salesOrder = service.save(salesOrder);

        //Set items
        salesOrder.setItems(Lists.<PplaOrderItem>newArrayList());
        for (Object o : salesOrderRet.getSalesOrderLineRetOrSalesOrderLineGroupRet()) {
            LOG.debug("Found sales order element. class={}", o.getClass());
            if (o instanceof SalesOrderLineRet) {
                SalesOrderLineRet salesOrderLineRet = (SalesOrderLineRet) o;

                //Try to find persisted
                PplaOrderItem orderItem = orderItemService.findByTxnLineId(salesOrderLineRet.getTxnLineID());
                if (null != orderItem) {
                    orderItem.setQuantity(BigDecimalUtil.tryParse(salesOrderLineRet.getQuantity()));
                } else {
                    orderItem = toOrderItem(salesOrderLineRet);
                    orderItem.setSalesOrder(salesOrder);
                    salesOrder.getItems().add(orderItem);
                }
                orderItemService.save(orderItem);
            } else {
                LOG.warn("Unsupported SalesOrderLineRetOrSalesOrderLineGroupRet. class={}", o.getClass());
            }
        }

        service.save(salesOrder);
    }

    private PplaPerson createCustomer(SalesOrderRet salesOrderRet) {
        LOG.debug("Creating customer. ref={}", salesOrderRet.getCustomerRef());
        PplaPerson customer = new PplaPerson();
        customer.setListId(salesOrderRet.getCustomerRef().getListID());

        String nameStr = salesOrderRet.getCustomerRef().getFullName();
        Name name = new Name();
        name.setGivenName(nameStr);
        name.setSurname("");
        customer.setName(name);

        return persons.save(customer);
    }

    private PplaOrderItem toOrderItem(SalesOrderLineRet salesOrderLineRet) {
        PplaOrderItem orderItem = new PplaOrderItem();

        //Set tracker
        orderItem.setTxnLineId(salesOrderLineRet.getTxnLineID());

        //Find product or create it
        String listId = salesOrderLineRet.getItemRef().getListID();
        PplaProduct product = productService.findByInventoryItemListId(listId);
        if (null == product) {
            InventoryItem ii = inventoryItemService.findByListId(listId);
            if (null == ii) {
                throw new IllegalStateException("Unknown product. list id=" + listId);
            }
            inventoryItemService.createInstanceAs(ii, PplaInventoryType.PRODUCT);
            product = productService.findByInventoryItemListId(listId);
        }
        orderItem.setProduct(product);

        //Set quantity
        if (null != salesOrderLineRet.getQuantity()) {
            orderItem.setQuantity(new BigDecimal(salesOrderLineRet.getQuantity()));
        } else {
            orderItem.setQuantity(BigDecimal.ZERO);
        }

        return orderItem;
    }
}
