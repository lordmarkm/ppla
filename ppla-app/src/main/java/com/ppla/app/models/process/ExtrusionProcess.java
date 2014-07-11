package com.ppla.app.models.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "EXTRUSION_PROCESS")
@DiscriminatorValue("EXTRUSION")
public class ExtrusionProcess extends MachineProcess {

}
