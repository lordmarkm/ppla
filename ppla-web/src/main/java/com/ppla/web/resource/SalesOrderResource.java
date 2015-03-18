package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigInteger;
import java.security.Principal;

import org.apache.commons.lang.RandomStringUtils;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.core.dto.PplaOrderItemInfo;
import com.ppla.core.dto.PplaSalesOrderInfo;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author Mark
 */
@RestController
@RequestMapping(value = "/salesorder")
public class SalesOrderResource {

    private static Logger LOG = LoggerFactory.getLogger(SalesOrderResource.class);

    @Autowired
    private PplaSalesOrderService salesOrders;

    @Autowired
    private PplaPersonService persons;

    @Autowired
    private PplaOrderItemService orderItems;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<PplaSalesOrderInfo>> findAll(Principal principal,
            @RequestParam int page,
            @RequestParam int count) {

        LOG.debug("Sales Order query. Principal={}, page={}, count={}", principal, page, count);

        PageRequest pageRequest = new PageRequest(page - 1, count);
        return new ResponseEntity<>(salesOrders.page(pageRequest), OK);
    }

    @RequestMapping(value = "/{trackingNo}", method = GET)
    public ResponseEntity<PplaSalesOrderInfo> findOne(Principal principal, @PathVariable String trackingNo) {
        LOG.debug("Sales order request. trackingNo={}, principal={}", trackingNo, principal);

        PplaSalesOrderInfo order = salesOrders.findInfoByTrackingNo(trackingNo);

        return new ResponseEntity<>(order, OK);
    }
    
    @RequestMapping(method = POST)
    public ResponseEntity<PplaSalesOrderInfo> save(Principal principal, @RequestBody PplaSalesOrderInfo salesOrderInfo) {
        LOG.debug("Sales order save request. salesOrder={}", salesOrderInfo);
        PplaSalesOrder salesOrder = salesOrders.findByTrackingNo(salesOrderInfo.getTrackingNo());
        if (null == salesOrder) {
            salesOrder = new PplaSalesOrder();
            salesOrderInfo.setTrackingNo(RandomStringUtils.randomAlphanumeric(6));
        }
        mapper.map(salesOrderInfo, salesOrder);

        salesOrder.setCustomer(persons.save(salesOrder.getCustomer()));
        salesOrder.setItems(null);
        salesOrder.setEditSequence(RandomStringUtils.randomAlphanumeric(10));
        salesOrder.setTimeModified(DateTime.now());
        salesOrder.setTxnNumber(BigInteger.valueOf(5));
        salesOrder = salesOrders.save(salesOrder);
        salesOrders.flush();
        
        for (PplaOrderItemInfo info : salesOrderInfo.getOrderItems()) {
            PplaOrderItem item = mapper.map(info, PplaOrderItem.class);
            item.setSalesOrder(salesOrder);
            item.setTxnLineId(RandomStringUtils.randomAlphanumeric(6));
            orderItems.save(item);
        }

        PplaSalesOrderInfo newInfo = toDto(salesOrder);

        return new ResponseEntity<>(newInfo, OK);
    }

    private PplaSalesOrderInfo toDto(PplaSalesOrder salesOrder) {
        return mapper.map(salesOrder, PplaSalesOrderInfo.class);
    }
}
