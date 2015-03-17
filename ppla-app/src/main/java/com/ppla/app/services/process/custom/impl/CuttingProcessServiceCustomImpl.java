package com.ppla.app.services.process.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.machine.Cutter;
import com.ppla.app.models.process.CuttingProcess;
import com.ppla.app.models.process.QCuttingProcess;
import com.ppla.app.servicebase.custom.AbstractPplaMachineProcessService;
import com.ppla.app.services.machine.CutterService;
import com.ppla.app.services.process.CuttingProcessService;
import com.ppla.app.services.process.custom.CuttingProcessServiceCustom;
import com.ppla.core.dto.process.CuttingProcessInfo;

/**
 * @author mbmartinez
 */
public class CuttingProcessServiceCustomImpl extends AbstractPplaMachineProcessService<

    CuttingProcess, 
    CuttingProcessInfo, 
    CuttingProcessService,
    Cutter,
    CutterService>

    implements CuttingProcessServiceCustom {

    @Autowired
    private CuttingProcessService service;

    @Override
    public CuttingProcessInfo startInfo(CuttingProcessInfo processInfo) {
        return super.startMachineProcessInfo(processInfo);
    }

    @Override
    public CuttingProcessInfo endInfo(CuttingProcessInfo processInfo) {
        return super.endMachineProcessInfo(processInfo);
    }

    @Override
    public CuttingProcessInfo findInfoByRollTag(String tag) {
        CuttingProcess process = service.findOne(
            QCuttingProcess.cuttingProcess.rollIn.tag.eq(tag)
        );
        return toDto(process);
    }

    @Override
    public CuttingProcessInfo pauseInfo(CuttingProcessInfo processInfo) {
        //Make machine available
        Cutter machine = toMachine(processInfo.getMachine());
        machine.setCurrentProcess(null);
        machineRepo.save(machine);

        processInfo.setPaused(true);
        return saveInfo(processInfo);
    }

    @Override
    public List<CuttingProcessInfo> findPaused() {
        List<CuttingProcess> pausedProcesses = (List<CuttingProcess>) service.findAll(
            QCuttingProcess.cuttingProcess.paused.isTrue(),
            QCuttingProcess.cuttingProcess.dateStarted.asc()
        );
        return toDto(pausedProcesses);
    }

}
