package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ppla.app.models.process.PrintingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("PRINTER")
public class Printer extends Machine<PrintingProcess> {

    @OneToOne
    @JoinColumn(name = "CURRENT_PROCESS")
    protected PrintingProcess currentProcess;

    public PrintingProcess getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(PrintingProcess currentProcess) {
        this.currentProcess = currentProcess;
    }

}
