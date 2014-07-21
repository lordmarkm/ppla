package com.ppla.core.dto.process;

import com.ppla.core.dto.machine.MachineInfo;

/**
 * @author Mark
 */
public abstract class MachineProcessInfo extends BasePplaProcessInfo {

    protected MachineInfo machine;

    public MachineInfo getMachine() {
        return machine;
    }

    public void setMachine(MachineInfo machine) {
        this.machine = machine;
    }

}
