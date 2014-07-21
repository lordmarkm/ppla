package com.ppla.core.dto.machine;

import com.ppla.core.dto.BasePplaDto;
import com.ppla.core.dto.process.MachineProcessInfo;

/**
 * @author Mark
 */
public class MachineInfo extends BasePplaDto {

    private MachineProcessInfo currentProcess;

    public MachineProcessInfo getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(MachineProcessInfo currentProcess) {
        this.currentProcess = currentProcess;
    }

}
