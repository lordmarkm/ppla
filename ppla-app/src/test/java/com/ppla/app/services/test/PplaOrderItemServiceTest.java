package com.ppla.app.services.test;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.PplaMainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.PplaPerson;
import com.ppla.app.models.PplaProduct;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.QPplaOrderItem;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.PplaProductService;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.app.services.PplaWorkOrderService;
import com.tyrael.commons.mapper.config.MapperConfig;

/**
 * @author Mark
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        MapperConfig.class,
        PplaMainConfig.class, 
        PplaPersistenceConfig.class
})
public class PplaOrderItemServiceTest {

    @Autowired
    private PplaOrderItemService service;

    @Autowired
    private PplaProductService products;

    @Autowired
    private PplaSalesOrderService salesOrders;

    @Autowired
    private PplaPersonService persons;

    @Autowired
    private PplaWorkOrderService wos;

    @Before
    @After
    public void init() {
        service.deleteAll();
        salesOrders.deleteAll();
        wos.deleteAll();
        products.deleteAll();
        persons.deleteAll();
    }

    private PplaOrderItem generic() {
        PplaPerson customer = new PplaPerson();
        persons.save(customer);

        PplaSalesOrder so = new PplaSalesOrder();
        so.setCustomer(customer);
        so.setTrackingNo(RandomStringUtils.random(5));
        so.setEditSequence("123");
        so.setTxnNumber(BigInteger.TEN);
        so.setTimeModified(DateTime.now());
        salesOrders.save(so);

        PplaProduct product = new PplaProduct();
        product.setName(RandomStringUtils.randomAlphanumeric(5));
        product.setDescription(RandomStringUtils.randomAlphanumeric(5));
        products.save(product);

        PplaOrderItem orderItem = new PplaOrderItem();
        orderItem.setProduct(product);
        orderItem.setSalesOrder(so);
        orderItem.setTxnLineId("123");
        return orderItem;
    }

    @Test
    public void testFindAttachable() {
        PplaOrderItem oi = generic();

        PplaWorkOrder wo = new PplaWorkOrder();
        wo.setQuantity(2);
        wo.setStatus(PplaWorkOrder.STATUS_OPEN);
        wo.setTrackingNo(RandomStringUtils.random(5));
        wos.save(wo);

        oi.setWorkOrder(wo);
        service.save(oi);

        //With closed WO
        PplaOrderItem oi2 = generic();

        PplaWorkOrder wo2 = new PplaWorkOrder();
        wo2.setQuantity(2);
        wo2.setStatus(PplaWorkOrder.STATUS_CLOSED);
        wo2.setTrackingNo(RandomStringUtils.random(5));
        wos.save(wo2);

        oi2.setWorkOrder(wo2);
        service.save(oi2);

        List<PplaOrderItem> saved = (List<PplaOrderItem>) 
                service.findAll(QPplaOrderItem.pplaOrderItem.workOrder.status.ne(PplaWorkOrder.STATUS_CLOSED));
        assertEquals(1, saved.size());
    }
}
