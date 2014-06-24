package com.ppla.app.services.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.MainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.services.PplaSalesOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class, PplaPersistenceConfig.class})
public class PplaSalesOrderServiceTest {

    @Autowired
    private PplaSalesOrderService service;

    @Test
    public void testRepo() {
        assertEquals(0, service.findAll());
    }
}
