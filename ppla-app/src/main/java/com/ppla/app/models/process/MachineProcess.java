package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ppla.app.models.Machine;
import com.tyrael.process.mgt.models.material.MaterialStack;

/**
 * @author mbmartinez
 */
public abstract class MachineProcess<M extends MaterialStack> extends BasePplaProcess {

    @ManyToOne
    private Machine machine;

    @OneToMany(cascade = CascadeType.ALL)
    private List<M> materialsIn;

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public List<M> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<M> materialsIn) {
        this.materialsIn = materialsIn;
    }

}
