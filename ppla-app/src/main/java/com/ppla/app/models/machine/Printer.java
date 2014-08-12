package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ppla.app.models.process.MixingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("PRINTER")
public class Printer extends Machine<MixingProcess> {

    @OneToOne
    @JoinColumn(name = "CURRENT_PROCESS")
    protected MixingProcess currentProcess;

    public MixingProcess getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(MixingProcess currentProcess) {
        this.currentProcess = currentProcess;
    }

}
