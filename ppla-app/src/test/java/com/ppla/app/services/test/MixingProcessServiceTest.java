package com.ppla.app.services.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.PplaMainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.models.PplaUser;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.services.PplaUserService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.process.MixingProcessService;
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
public class MixingProcessServiceTest {

    @Autowired
    private MixingProcessService service;

    @Autowired
    private PplaUserService users;

    @Autowired
    private PplaWorkOrderService wos;

    @Before
    @After
    public void init() {
        service.deleteAll();
        users.deleteAll();
        wos.deleteAll();
    }

    @Test
    public void testConfig() {
        PplaUser actor = new PplaUser();
        actor.setUsername("a");
        actor = users.save(actor);

        PplaWorkOrder wo = new PplaWorkOrder();
        wo.setTrackingNo("123");
        wo = wos.save(wo);

        MixingProcess process = new MixingProcess();
        process.setActor(actor);
        process.setWorkOrder(wo);
        process.setMaterialOutNetWt(BigDecimal.TEN);
        service.save(process);
        assertEquals(1, service.count());
    }

}
