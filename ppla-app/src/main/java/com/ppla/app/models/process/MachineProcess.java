package com.ppla.app.models.process;

import java.util.List;

import com.ppla.app.models.machine.Machine;
import com.tyrael.process.mgt.models.material.MaterialStack;

/**
 * @author mbmartinez
 */
public abstract class MachineProcess<M extends Machine, S extends MaterialStack> extends BasePplaProcess {

    public abstract List<S> getMaterialsIn();
    public abstract M getMachine();
    public abstract void setMachine(M machine);

}
