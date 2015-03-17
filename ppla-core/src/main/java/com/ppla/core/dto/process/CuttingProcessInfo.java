package com.ppla.core.dto.process;

import java.math.BigDecimal;

import com.ppla.core.dto.material.ProcessMaterialStackInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
public class CuttingProcessInfo extends MachineProcessInfo {

    private ProcessMaterialStackInfo rollIn;
    private BigDecimal productOut;
    private Boolean paused = false;

    @Override
    public ProcessType getType() {
        return ProcessType.CUTTING;
    }

    public ProcessMaterialStackInfo getRollIn() {
        return rollIn;
    }

    public void setRollIn(ProcessMaterialStackInfo rollIn) {
        this.rollIn = rollIn;
    }

    public BigDecimal getProductOut() {
        return productOut;
    }

    public void setProductOut(BigDecimal productOut) {
        this.productOut = productOut;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

}
