package com.ppla.core.dto.process;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.PplaWorkOrderInfo;
import com.ppla.core.dto.material.ProcessMaterialStackInfo;
import com.ppla.core.dto.material.RawMaterialStackInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author Mark
 */
public class MixingProcessInfo extends MachineProcessInfo {

    private List<RawMaterialStackInfo> materialsIn;
    private List<ProcessMaterialStackInfo> materialsOut;
    private BigDecimal materialsOutNetWt;

    /**
     * Unique to the Mixing Process, it can have multiple work
     * orders assigned to it.
     */
    private List<PplaWorkOrderInfo> workOrders;

    @Override
    public ProcessType getType() {
        return ProcessType.MIXING;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", id)
            .append("Type", getType())
            .append("Work orders", workOrders)
            .append("Machine", machine)
            .append("Started", dateStarted)
            .append("Completed", dateCompleted)
            .append("Actor", actor)
            .append("Materials in", materialsIn)
            .append("Materials out", materialsOut)
            .append("Mats out net weight", materialsOutNetWt)
            .append("Remarks", remarks)
            .toString();
    }

    public List<RawMaterialStackInfo> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<RawMaterialStackInfo> materialsIn) {
        this.materialsIn = materialsIn;
    }

    public List<ProcessMaterialStackInfo> getMaterialsOut() {
        return materialsOut;
    }

    public void setMaterialsOut(List<ProcessMaterialStackInfo> materialsOut) {
        this.materialsOut = materialsOut;
    }

    public BigDecimal getMaterialsOutNetWt() {
        return materialsOutNetWt;
    }

    public void setMaterialsOutNetWt(BigDecimal materialsOutNetWt) {
        this.materialsOutNetWt = materialsOutNetWt;
    }

    public List<PplaWorkOrderInfo> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<PplaWorkOrderInfo> workOrders) {
        this.workOrders = workOrders;
    }
}
