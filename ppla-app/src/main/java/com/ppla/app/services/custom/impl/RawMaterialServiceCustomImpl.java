package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ppla.app.models.RawMaterial;
import com.ppla.app.services.RawMaterialService;
import com.ppla.app.services.custom.RawMaterialServiceCustom;
import com.ppla.core.dto.material.RawMaterialInfo;

/**
 * @author mbmartinez
 */
public class RawMaterialServiceCustomImpl implements RawMaterialServiceCustom {

    @Autowired
    private Mapper mapper;

    @Autowired
    private RawMaterialService service;

    private RawMaterialInfo toDto(RawMaterial rawMaterial) {
        return mapper.map(rawMaterial, RawMaterialInfo.class);
    }

    @Override
    public List<RawMaterialInfo> findAllNonDeleted() {
        List<RawMaterial> rawMaterials = service.findByDeleted(false);
        List<RawMaterialInfo> dtos = Lists.newArrayList();
        for (RawMaterial rawMaterial : rawMaterials) {
            dtos.add(toDto(rawMaterial));
        }
        return dtos;
    }

    @Override
    public RawMaterialInfo save(RawMaterialInfo newMaterial) {
        RawMaterial newRawMaterial = mapper.map(newMaterial, RawMaterial.class);
        return toDto(service.save(newRawMaterial));
    }

}
