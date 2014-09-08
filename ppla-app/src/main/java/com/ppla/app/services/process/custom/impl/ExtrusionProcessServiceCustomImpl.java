package com.ppla.app.services.process.custom.impl;

import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.process.ExtrusionProcess;
import com.ppla.app.servicebase.custom.AbstractPplaMachineProcessService;
import com.ppla.app.services.machine.ExtruderService;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.app.services.process.custom.ExtrusionProcessServiceCustom;
import com.ppla.core.dto.process.ExtrusionProcessInfo;

/**
 * @author mbmartinez
 */
public class ExtrusionProcessServiceCustomImpl 

    extends AbstractPplaMachineProcessService<
        ExtrusionProcess, 
        ExtrusionProcessInfo, 
        ExtrusionProcessService,
        Extruder,
        ExtruderService>
    
    implements ExtrusionProcessServiceCustom {

    @Override
    public ExtrusionProcessInfo startInfo(ExtrusionProcessInfo processInfo) {
        return super.startMachineProcessInfo(processInfo);
    }

    @Override
    public ExtrusionProcessInfo endInfo(ExtrusionProcessInfo processInfo) {
        return super.endMachineProcessInfo(processInfo);
    }
}
