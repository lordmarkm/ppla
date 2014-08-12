package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ppla.app.models.process.ExtrusionProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("EXTRUDER")
public class Extruder extends Machine<ExtrusionProcess> {

    @OneToOne
    @JoinColumn(name = "CURRENT_PROCESS")
    protected ExtrusionProcess currentProcess;

    public ExtrusionProcess getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(ExtrusionProcess currentProcess) {
        this.currentProcess = currentProcess;
    }

}
