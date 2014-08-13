package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.material.ProcessMaterialStack;

@Entity(name = "EXTRUSION_PROCESS")
@DiscriminatorValue("EXTRUSION")
public class ExtrusionProcess extends MachineProcess<Extruder, ProcessMaterialStack> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialsIn;

    public List<ProcessMaterialStack> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<ProcessMaterialStack> materialsIn) {
        this.materialsIn = materialsIn;
    }

}
