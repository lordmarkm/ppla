package com.ppla.app.models.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "PRINTING_PROCESS")
@DiscriminatorValue("PRINTING")
public class PrintingProcess extends MachineProcess {

}
