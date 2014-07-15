package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ppla.app.models.material.ProcessMaterial;
import com.ppla.app.services.ProcessMaterialService;
import com.ppla.app.services.custom.ProcessMaterialServiceCustom;
import com.ppla.core.dto.material.ProcessMaterialInfo;

/**
 * @author mbmartinez
 */
public class ProcessMaterialServiceCustomImpl implements ProcessMaterialServiceCustom {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ProcessMaterialService service;

    private ProcessMaterialInfo toDto(ProcessMaterial processMaterial) {
        return mapper.map(processMaterial, ProcessMaterialInfo.class);
    }

    @Override
    public List<ProcessMaterialInfo> findAllNonDeleted() {
        List<ProcessMaterial> processMaterials = service.findByDeleted(false);
        List<ProcessMaterialInfo> dtos = Lists.newArrayList();
        for (ProcessMaterial p : processMaterials) {
            dtos.add(toDto(p));
        }
        return dtos;
    }

    @Override
    public ProcessMaterialInfo save(ProcessMaterialInfo newMaterial) {
        return toDto(service.save(mapper.map(newMaterial, ProcessMaterial.class)));
    }

}
