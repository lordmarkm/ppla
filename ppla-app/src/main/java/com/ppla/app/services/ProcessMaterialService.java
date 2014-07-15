package com.ppla.app.services;

import com.ppla.app.models.material.ProcessMaterial;
import com.ppla.app.servicebase.BasePplaMaterialService;
import com.ppla.app.services.custom.ProcessMaterialServiceCustom;

/**
 * @author mbmartinez
 */
public interface ProcessMaterialService
    extends BasePplaMaterialService<ProcessMaterial>, ProcessMaterialServiceCustom {

}
