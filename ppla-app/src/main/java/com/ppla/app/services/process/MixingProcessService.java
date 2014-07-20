package com.ppla.app.services.process;

import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.process.custom.MixingProcessServiceCustom;

/**
 * @author Mark
 */
public interface MixingProcessService extends BasePplaProcessService<MixingProcess>,
    MixingProcessServiceCustom {

}
