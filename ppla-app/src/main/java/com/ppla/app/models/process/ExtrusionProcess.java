package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mysema.query.annotations.QueryInit;
import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.material.ProcessMaterialStack;

@Entity(name = "EXTRUSION_PROCESS")
@DiscriminatorValue("EXTRUSION")
public class ExtrusionProcess extends MachineProcess<Extruder, ProcessMaterialStack> {

    @ManyToOne
    @JoinColumn(name = "MACHINE_ID")
    private Extruder machine;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "EXTRUSION_MATERIALS_IN",
        joinColumns = {
            @JoinColumn(name = "MATERIAL_ID")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "PROCESS_ID")
        }
    )
    private List<ProcessMaterialStack> materialsIn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "EXTRUSION_MATERIALS_OUT",
        joinColumns = {
            @JoinColumn(name = "MATERIAL_ID")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "PROCESS_ID")
        }
    )
    @QueryInit("*")
    private List<ProcessMaterialStack> materialsOut;

    public List<ProcessMaterialStack> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<ProcessMaterialStack> materialsIn) {
        this.materialsIn = materialsIn;
    }

    public Extruder getMachine() {
        return machine;
    }

    public void setMachine(Extruder machine) {
        this.machine = machine;
    }

    public List<ProcessMaterialStack> getMaterialsOut() {
        return materialsOut;
    }

    public void setMaterialsOut(List<ProcessMaterialStack> materialsOut) {
        this.materialsOut = materialsOut;
    }

}
