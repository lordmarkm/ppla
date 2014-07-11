package com.ppla.app.models.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "MIXING_PROCESS")
@DiscriminatorValue("MIXING")
public class MixingProcess extends MachineProcess {

}
