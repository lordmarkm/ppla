package com.ppla.app.services.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.PplaMainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.models.process.MixingProcess;
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

    @Test
    public void testConfig() {
        MixingProcess process = new MixingProcess();
        service.save(process);
        assertEquals(1, service.count());
    }

}
