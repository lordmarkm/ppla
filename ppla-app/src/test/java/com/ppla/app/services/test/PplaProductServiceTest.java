package com.ppla.app.services.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.MainConfig;
import com.ppla.app.config.PplaPersistenceConfig;
import com.ppla.app.models.PplaProduct;
import com.ppla.app.services.PplaProductService;

/**
 * @author Mark
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class, PplaPersistenceConfig.class})
public class PplaProductServiceTest {

    @Autowired
    private PplaProductService products;

    @Test
    public void testPagination() {
        PplaProduct prod1 = new PplaProduct();
        prod1.setName("somename");
        prod1.setDescription("somdesc");
        products.save(prod1);

        PplaProduct prod2 = new PplaProduct();
        prod2.setName("somename");
        prod2.setDescription("somdesc");
        products.save(prod2);

        assertEquals(2, products.count());
    }
}
