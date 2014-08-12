package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ppla.app.models.process.CuttingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("CUTTER")
public class Cutter extends Machine<CuttingProcess> {

    @OneToOne
    @JoinColumn(name = "CURRENT_PROCESS")
    protected CuttingProcess currentProcess;

    public CuttingProcess getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(CuttingProcess currentProcess) {
        this.currentProcess = currentProcess;
    }

}
