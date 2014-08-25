package com.ppla.app.services;

import java.util.List;

import com.ppla.app.models.material.RawMaterial;
import com.ppla.app.servicebase.BasePplaMaterialService;
import com.ppla.app.services.custom.RawMaterialServiceCustom;
import com.ppla.core.dto.material.RawMaterialInfo;

/**
 * @author mbmartinez
 */
public interface RawMaterialService
    extends BasePplaMaterialService<RawMaterial>, RawMaterialServiceCustom {

}
