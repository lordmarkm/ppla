package com.ppla.app.models.process;

import javax.persistence.ManyToOne;

import com.ppla.app.models.Machine;

/**
 * @author mbmartinez
 */
public abstract class MachineProcess extends BasePplaProcess {

    @ManyToOne
    private Machine machine;

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

}
