package com.ppla.app.models.process;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.machine.Printer;
import com.ppla.app.models.material.ProcessMaterialStack;

@Entity(name = "PRINTING_PROCESS")
@DiscriminatorValue("PRINTING")
public class PrintingProcess extends MachineProcess<Printer, ProcessMaterialStack> {

}
