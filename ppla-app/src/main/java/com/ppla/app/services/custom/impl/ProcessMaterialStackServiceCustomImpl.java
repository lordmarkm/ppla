package com.ppla.app.services.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.services.ProcessMaterialStackService;
import com.ppla.app.services.custom.ProcessMaterialStackServiceCustom;
import com.ppla.core.dto.material.ProcessMaterialStackInfo;
import com.tyrael.commons.mapper.service.MappingService;

/**
 * @author mbmartinez
 */
public class ProcessMaterialStackServiceCustomImpl extends MappingService<ProcessMaterialStack, ProcessMaterialStackInfo>
    implements ProcessMaterialStackServiceCustom {

    @Autowired
    private ProcessMaterialStackService service;

    @Override
    public ProcessMaterialStackInfo findInfoByTag(String tag) {
        return toDto(service.findByTag(tag));
    }

}
