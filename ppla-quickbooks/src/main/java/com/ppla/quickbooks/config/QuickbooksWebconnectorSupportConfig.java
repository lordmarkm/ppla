package com.ppla.quickbooks.config;

import static org.dozer.loader.api.FieldsMappingOptions.*;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ppla.quickbooks.converter.DateTimeConverter;
import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.ppla.quickbooks.entity.InventoryItem;
import com.ppla.quickbooks.entity.generated.ItemInventoryRet;

@Configuration
public class QuickbooksWebconnectorSupportConfig {

    @Autowired
    private DozerBeanMapper mapper;

    @PostConstruct
    public void init() {
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(ItemInventoryRet.class, InventoryItem.class)
                    .fields("timeModified", "timeModified", customConverter(DateTimeConverter.class));
                mapping(InventoryItem.class, InventoryItemInfo.class)
                    .fields("timeModified", "timeModified", copyByReference());
            }
        });
    }
}
