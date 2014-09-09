package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.common.collect.Lists;
import com.mysema.query.annotations.QueryInit;
import com.ppla.app.models.machine.Printer;
import com.ppla.app.models.material.ProcessMaterialStack;

@Entity(name = "PRINTING_PROCESS")
@DiscriminatorValue("PRINTING")
public class PrintingProcess extends MachineProcess<Printer, ProcessMaterialStack> {

    @ManyToOne
    @JoinColumn(name = "MACHINE_ID")
    private Printer machine;

    @ManyToOne
    @JoinColumn(name = "ROLL_IN_STACK_ID", nullable = false)
    @QueryInit("*")
    private ProcessMaterialStack rollIn;

    @Override
    public List<ProcessMaterialStack> getMaterialsIn() {
        return Lists.newArrayList(rollIn);
    }

    public Printer getMachine() {
        return machine;
    }

    public void setMachine(Printer machine) {
        this.machine = machine;
    }

    public ProcessMaterialStack getRollIn() {
        return rollIn;
    }

    public void setRollIn(ProcessMaterialStack rollIn) {
        this.rollIn = rollIn;
    }

}
