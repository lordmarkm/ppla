package com.ppla.app.services.process;

import com.ppla.app.models.process.ExtrusionProcess;
import com.ppla.app.servicebase.BasePplaMachineProcessService;
import com.ppla.app.services.process.custom.ExtrusionProcessServiceCustom;

/**
 * @author mbmartinez
 */
public interface ExtrusionProcessService extends BasePplaMachineProcessService<ExtrusionProcess>,
    ExtrusionProcessServiceCustom {

}
