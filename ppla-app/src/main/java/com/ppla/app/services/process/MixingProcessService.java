package com.ppla.app.services.process;

import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.servicebase.BasePplaMachineProcessService;
import com.ppla.app.services.process.custom.MixingProcessServiceCustom;

/**
 * @author Mark
 */
public interface MixingProcessService extends BasePplaMachineProcessService<MixingProcess>,
    MixingProcessServiceCustom {

}
