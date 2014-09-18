package com.ppla.app.services.process;

import com.ppla.app.models.process.CuttingProcess;
import com.ppla.app.servicebase.BasePplaMachineProcessService;
import com.ppla.app.services.process.custom.CuttingProcessServiceCustom;

/**
 * @author mbmartinez
 */
public interface CuttingProcessService extends BasePplaMachineProcessService<CuttingProcess>,
    CuttingProcessServiceCustom {

}
