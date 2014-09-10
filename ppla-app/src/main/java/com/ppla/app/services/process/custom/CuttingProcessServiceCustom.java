package com.ppla.app.services.process.custom;

import com.ppla.app.servicebase.BasePplaProcessServiceCustom;
import com.ppla.core.dto.process.CuttingProcessInfo;

/**
 * @author mbmartinez
 */
public interface CuttingProcessServiceCustom extends BasePplaProcessServiceCustom<CuttingProcessInfo> {

    CuttingProcessInfo findInfoByRollTag(String tag);

}
