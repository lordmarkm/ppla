package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.machine.Printer;
import com.ppla.app.models.material.ProcessMaterialStack;

@Entity(name = "PRINTING_PROCESS")
@DiscriminatorValue("PRINTING")
public class PrintingProcess extends MachineProcess<Printer, ProcessMaterialStack> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialsIn;

    public List<ProcessMaterialStack> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<ProcessMaterialStack> materialsIn) {
        this.materialsIn = materialsIn;
    }

}
