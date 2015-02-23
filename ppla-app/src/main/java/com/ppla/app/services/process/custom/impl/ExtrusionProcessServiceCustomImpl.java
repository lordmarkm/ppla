package com.ppla.app.services.process.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.process.ExtrusionProcess;
import com.ppla.app.servicebase.custom.AbstractPplaMachineProcessService;
import com.ppla.app.services.machine.ExtruderService;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.app.services.process.custom.ExtrusionProcessServiceCustom;
import com.ppla.app.util.TagGenerator;
import com.ppla.core.dto.material.ProcessMaterialStackInfo;
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

    private static Logger LOG = LoggerFactory.getLogger(ExtrusionProcessServiceCustomImpl.class);

    @Autowired
    private TagGenerator tagGenerator;

    @Override
    public ExtrusionProcessInfo startInfo(ExtrusionProcessInfo processInfo) {
        return super.startMachineProcessInfo(processInfo);
    }

    @Override
    public ExtrusionProcessInfo endInfo(ExtrusionProcessInfo processInfo) {
        for (ProcessMaterialStackInfo outputStack : processInfo.getMaterialsOut()) {
            outputStack.setTag(tagGenerator.next());
            outputStack.setWorkorderTrackingNo(processInfo.getWorkOrder().getTrackingNo());
        }
        return super.endMachineProcessInfo(processInfo);
    }

    @Override
    public ExtrusionProcessInfo unloadInfo(ExtrusionProcessInfo processInfo) {
        for (ProcessMaterialStackInfo outputStack : processInfo.getMaterialsOut()) {
            outputStack.setTag(tagGenerator.next());
            outputStack.setWorkorderTrackingNo(processInfo.getWorkOrder().getTrackingNo());
        }
        ExtrusionProcessInfo oldProcess = super.endMachineProcessInfo(processInfo);

        ExtrusionProcessInfo newProcess = new ExtrusionProcessInfo();
        newProcess.setActor(oldProcess.getEndActor());
        newProcess.setDateStarted(oldProcess.getDateCompleted());
        newProcess.setMachine(oldProcess.getMachine());
        newProcess.setRemarks(oldProcess.getRemarks());
        newProcess.setWorkOrder(oldProcess.getWorkOrder());

        LOG.debug("Starting new extrusion process. process={}", newProcess);
        startInfo(newProcess);

        return oldProcess;
    }

}
