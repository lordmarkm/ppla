package com.ppla.app.models.process;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.common.collect.Lists;
import com.mysema.query.annotations.QueryInit;
import com.ppla.app.models.machine.Cutter;
import com.ppla.app.models.material.ProcessMaterialStack;

/**
 * @author mbmartinez
 */
@Entity(name = "CUTTING_PROCESS")
@DiscriminatorValue("CUTTING")
public class CuttingProcess extends MachineProcess<Cutter, ProcessMaterialStack> {

    @ManyToOne
    @JoinColumn(name = "MACHINE_ID")
    private Cutter machine;

    @ManyToOne
    @JoinColumn(name = "ROLL_IN_STACK_ID", nullable = false)
    @QueryInit("*")
    private ProcessMaterialStack rollIn;

    @Column(name = "OUTPUT")
    private BigDecimal productOut;

    @Column(name = "PAUSED")
    private Boolean paused = false;

    @Override
    public List<ProcessMaterialStack> getMaterialsIn() {
        return Lists.newArrayList(rollIn);
    }

    public BigDecimal getProductOut() {
        return productOut;
    }
    public void setProductOut(BigDecimal productOut) {
        this.productOut = productOut;
    }
    @Override
    public Cutter getMachine() {
        return machine;
    }
    @Override
    public void setMachine(Cutter machine) {
        this.machine = machine;
    }
    public ProcessMaterialStack getRollIn() {
        return rollIn;
    }
    public void setRollIn(ProcessMaterialStack rollIn) {
        this.rollIn = rollIn;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

}
