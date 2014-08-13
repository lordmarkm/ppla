package com.ppla.app.config;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.tyrael.commons.mapper.config.MapperConfig;

import static org.dozer.loader.api.FieldsMappingOptions.*;

/**
 * Initialize the Dozer mapper for application-wide use.
 * @author mbmartinez
 */
@Configuration
@Import(MapperConfig.class)
public class SupportConfig {

    @Autowired
    private DozerBeanMapper mapper;

    @PostConstruct
    public void init() {
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
//                mapping(BasePplaProcess.class, BasePplaProcessInfo.class)
//                    .fields("workOrder.trackingNo", "workOrderTrackingNo", oneWay());
            }
        });
    }
}
