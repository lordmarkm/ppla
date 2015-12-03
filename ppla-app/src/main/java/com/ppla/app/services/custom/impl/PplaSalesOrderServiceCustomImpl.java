package com.ppla.app.services.custom.impl;

import java.math.BigInteger;
import java.util.List;

import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baldy.commons.models.proper.Name;
import com.google.common.collect.Lists;
import com.ppla.app.models.PplaPerson;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.app.services.custom.PplaSalesOrderServiceCustom;
import com.ppla.core.dto.PplaSalesOrderInfo;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author Mark
 */
public class PplaSalesOrderServiceCustomImpl implements PplaSalesOrderServiceCustom {

    private static final String DEFAULT_TRACKING_NO = "DEFAULT_TRACKING_NO";

    @Autowired
    private Mapper mapper;

    @Autowired
    private PplaSalesOrderService service;

    @Autowired
    private PplaPersonService personService;

    private PplaSalesOrderInfo toDto(PplaSalesOrder salesOrder) {
        return mapper.map(salesOrder, PplaSalesOrderInfo.class);
    }

    @Override
    public PplaSalesOrder getDefault() {
        PplaSalesOrder defaultSalesOrder = service.findByTrackingNo(DEFAULT_TRACKING_NO);
        if (null == defaultSalesOrder) {
            Name defaultCustName = new Name();
            defaultCustName.setGivenName("Default");
            defaultCustName.setSurname("Default");
            PplaPerson defaultCust = new PplaPerson();
            defaultCust.setName(defaultCustName);
            defaultCust = personService.save(defaultCust);

            defaultSalesOrder = new PplaSalesOrder();
            defaultSalesOrder.setTrackingNo(DEFAULT_TRACKING_NO);
            defaultSalesOrder.setCustomer(defaultCust);
            defaultSalesOrder.setDateCreated(DateTime.now());
            defaultSalesOrder.setEditSequence("1");
            defaultSalesOrder.setPurchaseOrderNo("1");
            defaultSalesOrder.setTxnNumber(BigInteger.ONE);
            defaultSalesOrder.setTimeModified(DateTime.now());
            defaultSalesOrder = service.save(defaultSalesOrder);
        }
        return defaultSalesOrder;
    }

    @Override
    public PplaSalesOrderInfo findInfoByTrackingNo(String trackingNo) {
        PplaSalesOrder salesOrder = service.findByTrackingNo(trackingNo);
        PplaSalesOrderInfo salesOrderInfo = toDto(salesOrder);

        return salesOrderInfo;
    }

    @Override
    public PageInfo<PplaSalesOrderInfo> page(Pageable page) {
        Page<PplaSalesOrder> results = service.findAll(page);
        List<PplaSalesOrderInfo> infos = Lists.newArrayList();
        for (PplaSalesOrder order : results) {
            infos.add(mapper.map(order, PplaSalesOrderInfo.class));
        }

        PageInfo<PplaSalesOrderInfo> pageResponse = new PageInfo<>();
        pageResponse.setData(infos);
        pageResponse.setTotal(results.getTotalElements());
        return pageResponse;
    }

}
