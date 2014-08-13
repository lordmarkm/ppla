package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.ManyToOne;

import com.ppla.app.models.machine.Machine;
import com.tyrael.process.mgt.models.material.MaterialStack;

/**
 * @author mbmartinez
 */
public abstract class MachineProcess<M extends Machine, S extends MaterialStack> extends BasePplaProcess {

    @ManyToOne
    private M machine;

    public abstract List<S> getMaterialsIn();

    public M getMachine() {
        return machine;
    }

    public void setMachine(M machine) {
        this.machine = machine;
    }

}
