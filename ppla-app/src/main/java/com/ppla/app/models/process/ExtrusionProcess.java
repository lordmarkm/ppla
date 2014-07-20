package com.ppla.app.models.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.material.ProcessMaterialStack;

@Entity(name = "EXTRUSION_PROCESS")
@DiscriminatorValue("EXTRUSION")
public class ExtrusionProcess extends MachineProcess<Extruder, ProcessMaterialStack> {

}
