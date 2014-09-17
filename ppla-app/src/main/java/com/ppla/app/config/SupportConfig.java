package com.ppla.app.config;

import static org.dozer.loader.api.FieldsMappingOptions.oneWay;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.machine.Cutter;
import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.machine.Machine;
import com.ppla.app.models.machine.Mixer;
import com.ppla.app.models.machine.Printer;
import com.ppla.core.dto.PplaWorkOrderInfo;
import com.ppla.core.dto.machine.MachineInfo;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.tyrael.commons.mapper.config.MapperConfig;
import com.tyrael.process.mgt.models.process.Process;
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
                mapping(PplaWorkOrder.class, PplaWorkOrderInfo.class)
                    .fields("dateCreated", "dateCreated", copyByReference())
                    .fields("dateCompleted", "dateCompleted", copyByReference());
                mapping(Machine.class, MachineInfo.class)
                    .fields("currentProcess.id", "currentProcessId", oneWay());
//                mapping(Mixer.class, MachineInfo.class)
//                    .fields("currentProcess.id", "currentProcessId", oneWay());
//                mapping(Extruder.class, MachineInfo.class)
//                    .fields("currentProcess.id", "currentProcessId", oneWay());
//                mapping(Printer.class, MachineInfo.class)
//                    .fields("currentProcess.id", "currentProcessId", oneWay());
//                mapping(Cutter.class, MachineInfo.class)
//                    .fields("currentProcess.id", "currentProcessId", oneWay());
                mapping(Process.class, BasePplaProcessInfo.class)
                    .fields("dateStarted", "dateStarted", copyByReference())
                    .fields("dateCompleted", "dateCompleted", copyByReference());
            }
        });
    }
}
