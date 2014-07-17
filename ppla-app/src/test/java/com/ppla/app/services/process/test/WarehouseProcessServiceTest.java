package com.ppla.app.services.process.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.PplaMainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.services.process.WarehouseProcessService;
import com.tyrael.commons.mapper.config.MapperConfig;

/**
 * @author mbmartinez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    MapperConfig.class,
    PplaMainConfig.class, 
    PplaPersistenceConfig.class
})
public class WarehouseProcessServiceTest {

    @Autowired
    private WarehouseProcessService service;

    @Test
    @Ignore
    public void testWarehouseProcess() {
        assertNotNull(service);
    }
}
