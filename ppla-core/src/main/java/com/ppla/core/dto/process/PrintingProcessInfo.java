package com.ppla.core.dto.process;

import com.ppla.core.dto.material.ProcessMaterialStackInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
public class PrintingProcessInfo extends MachineProcessInfo {

    private ProcessMaterialStackInfo rollIn;
    private ProcessMaterialStackInfo materialsOut;

    @Override
    public ProcessType getType() {
        return ProcessType.PRINTING;
    }

    public ProcessMaterialStackInfo getRollIn() {
        return rollIn;
    }

    public void setRollIn(ProcessMaterialStackInfo rollIn) {
        this.rollIn = rollIn;
    }

    public ProcessMaterialStackInfo getMaterialsOut() {
        return materialsOut;
    }

    public void setMaterialsOut(ProcessMaterialStackInfo materialsOut) {
        this.materialsOut = materialsOut;
    }

}
