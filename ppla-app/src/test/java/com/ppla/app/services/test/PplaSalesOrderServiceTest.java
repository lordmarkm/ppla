package com.ppla.app.services.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.MainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.models.PplaPerson;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.PplaSalesOrderService;
import com.ppla.core.dto.PplaSalesOrderInfo;
import com.tyrael.commons.mapper.config.MapperConfig;

/**
 * @author Mark
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class, PplaPersistenceConfig.class, MapperConfig.class})
public class PplaSalesOrderServiceTest {

    @Autowired
    private PplaSalesOrderService service;

    @Autowired
    private PplaPersonService persons;

    @Test
    public void testRepo() {
        assertEquals(0, service.findAll().size());
    }

    @Test
    public void testCustomMethod() {
        String trackingNo = "abc";

        PplaPerson customer = persons.saveAndFlush(new PplaPerson());

        PplaSalesOrder so = new PplaSalesOrder();
        so.setTrackingNo(trackingNo);
        so.setCustomer(customer);
        service.save(so);

        PplaSalesOrderInfo info = service.assemble(trackingNo);
        
        assertEquals(trackingNo, info.getTrackingNo());
    }
}
