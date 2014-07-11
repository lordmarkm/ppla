package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.core.dto.material.ProcessMaterialInfo;

/**
 * @author mbmartinez
 */
public interface ProcessMaterialServiceCustom {

    List<ProcessMaterialInfo> findAllNonDeleted();
    ProcessMaterialInfo save(ProcessMaterialInfo newMaterial);

}
