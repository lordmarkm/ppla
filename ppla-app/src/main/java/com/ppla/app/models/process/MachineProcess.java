package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ppla.app.models.machine.Machine;
import com.tyrael.process.mgt.models.material.MaterialStack;

/**
 * @author mbmartinez
 */
public abstract class MachineProcess<M extends Machine, S extends MaterialStack> extends BasePplaProcess {

    @ManyToOne
    private M machine;

    @OneToMany(cascade = CascadeType.ALL)
    private List<S> materialsIn;

    public M getMachine() {
        return machine;
    }

    public void setMachine(M machine) {
        this.machine = machine;
    }

    public List<S> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<S> materialsIn) {
        this.materialsIn = materialsIn;
    }

}
