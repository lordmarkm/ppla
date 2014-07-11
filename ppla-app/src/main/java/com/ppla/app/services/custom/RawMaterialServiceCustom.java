package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.core.dto.material.RawMaterialInfo;

/**
 * @author mbmartinez
 */
public interface RawMaterialServiceCustom {

    List<RawMaterialInfo> findAllNonDeleted();
    RawMaterialInfo save(RawMaterialInfo newMaterial);

}
