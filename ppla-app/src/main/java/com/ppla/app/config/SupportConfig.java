package com.ppla.app.config;

import static org.dozer.loader.api.FieldsMappingOptions.oneWay;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ppla.app.models.machine.Mixer;
import com.ppla.core.dto.machine.MachineInfo;
import com.tyrael.commons.mapper.config.MapperConfig;

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
                mapping(Mixer.class, MachineInfo.class)
                    .fields("currentProcess.id", "currentProcessId", oneWay());
            }
        });
    }
}
