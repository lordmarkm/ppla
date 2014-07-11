package com.ppla.app.services;

import com.ppla.app.models.RawMaterial;
import com.ppla.app.servicebase.BasePplaMaterialService;
import com.ppla.app.services.custom.RawMaterialServiceCustom;

/**
 * @author mbmartinez
 */
public interface RawMaterialService
    extends BasePplaMaterialService<RawMaterial>, RawMaterialServiceCustom {

}
