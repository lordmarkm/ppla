package com.ppla.app.services.process;

import com.ppla.app.models.process.CuttingProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.process.custom.CuttingProcessServiceCustom;

/**
 * @author mbmartinez
 */
public interface CuttingProcessService extends BasePplaProcessService<CuttingProcess>,
    CuttingProcessServiceCustom {

}
