package com.ppla.web.resource;

import java.security.Principal;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.core.dto.PplaSalesOrderInfo;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import static org.springframework.http.HttpStatus.*;

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
    private Mapper mapper;

    @RequestMapping(method = GET)
    public ResponseEntity<List<PplaSalesOrderInfo>> findAll(Principal principal) {
        LOG.debug("All sales orders requested. principal={}", principal);

        List<PplaSalesOrder> orders = salesOrders.findAll();
        List<PplaSalesOrderInfo> infos = Lists.newArrayList();
        for (PplaSalesOrder order : orders) {
            infos.add(mapper.map(order, PplaSalesOrderInfo.class));
        }

        return new ResponseEntity<>(infos, OK);
    }

    @RequestMapping(value = "/{trackingNo}", method = GET)
    public ResponseEntity<PplaSalesOrderInfo> findOne(Principal principal, @PathVariable String trackingNo) {
        LOG.debug("Sales order request. trackingNo={}, principal={}", trackingNo, principal);

        PplaSalesOrder order = salesOrders.findByTrackingNo(trackingNo);

        return new ResponseEntity<>(mapper.map(order, PplaSalesOrderInfo.class), OK);
    }
}
