package com.ppla.quickbooks.config;

import static org.dozer.loader.api.FieldsMappingOptions.*;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ppla.app.models.PplaProduct;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.models.material.PplaMaterial;
import com.ppla.quickbooks.converter.DateTimeConverter;
import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.entity.generated.ItemInventoryRet;
import com.ppla.quickbooks.entity.generated.SalesOrderRet;

@Configuration
public class QuickbooksWebconnectorSupportConfig {

    @Autowired
    private DozerBeanMapper mapper;

    @PostConstruct
    public void init() {
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
//            	ItemInventoryRet iir;
//            	iir.getPurchaseDesc();
//            	iir.getEditSequence();
                mapping(ItemInventoryRet.class, InventoryItem.class, TypeMappingOptions.wildcard(true), TypeMappingOptions.oneWay())
//                	.fields("listId", "listId")
//                	.fields("name", "name")
                	.fields("purchaseDesc", "description")
//                	.fields("editSequence", "editSequence")
//                	.fields("quantityOnHand", "quantityOnHand")
                    .fields("timeModified", "timeModified", customConverter(DateTimeConverter.class));
                mapping(InventoryItem.class, InventoryItemInfo.class)
                    .fields("timeModified", "timeModified", copyByReference());

                //Sales order
                mapping(SalesOrderRet.class, PplaSalesOrder.class, TypeMappingOptions.wildcard(true), TypeMappingOptions.oneWay())
                    .fields("timeModified", "dateCreated", customConverter(DateTimeConverter.class));

                    //Prevent id from being overriden
                mapping(InventoryItem.class, PplaProduct.class)
                    .exclude("id");
                mapping(InventoryItem.class, PplaMaterial.class)
                    .exclude("id");
            }
        });
    }
}
