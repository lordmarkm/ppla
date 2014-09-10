package com.ppla.app.services.custom;

import com.ppla.core.dto.material.ProcessMaterialStackInfo;

/**
 * @author mbmartinez
 */
public interface ProcessMaterialStackServiceCustom {

    ProcessMaterialStackInfo findInfoByTag(String tag);

}
