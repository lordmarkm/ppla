package com.ppla.app.services.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.PplaMainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.models.material.RawMaterial;
import com.ppla.app.services.RawMaterialService;
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
public class RawMaterialServiceTest {

    @Autowired
    private RawMaterialService service;

    private RawMaterial generic() {
        RawMaterial r = new RawMaterial();
        r.setName("Some name");
        r.setDescription("Some desc");
        return r;
    }

    @Before
    public void clear() {
        service.deleteAll();
    }

    @Test
    public void test() {
        RawMaterial r = generic();
        service.save(r);

        assertEquals(1, service.count());
    }

    @Test
    public void testFindByDeleted() {
        RawMaterial r = generic();
        r.setDeleted(true);
        service.save(r);

        assertEquals(1, service.count());
        assertEquals(1, service.findByDeleted(true).size());
        assertEquals(0, service.findByDeleted(false).size());
    }

    @Test
    public void testSave() {
        
    }
}
