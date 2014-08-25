package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ppla.app.models.material.ProcessMaterial;
import com.ppla.app.services.ProcessMaterialService;
import com.ppla.app.services.custom.ProcessMaterialServiceCustom;
import com.ppla.core.dto.material.ProcessMaterialInfo;
import com.ppla.core.reference.MaterialSource;
import com.tyrael.commons.mapper.service.MappingService;

/**
 * @author mbmartinez
 */
public class ProcessMaterialServiceCustomImpl extends MappingService<ProcessMaterial, ProcessMaterialInfo>
    implements ProcessMaterialServiceCustom {

    @Autowired
    private ProcessMaterialService service;

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
    public List<ProcessMaterialInfo> findBySourceInfo(String source) {
        List<ProcessMaterial> processMaterials = service.findBySourceAndDeleted(MaterialSource.valueOf(source), false);
        return toDto(processMaterials);
    }

    @Override
    public ProcessMaterialInfo save(ProcessMaterialInfo newMaterial) {
        return toDto(service.save(mapper.map(newMaterial, ProcessMaterial.class)));
    }

}
