package com.ppla.core.dto.process;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.material.RawMaterialStackInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
public class WarehouseProcessInfo extends BasePplaProcessInfo {

    private List<RawMaterialStackInfo> materialStacks;

    @Override
    public ProcessType getType() {
        return ProcessType.WAREHOUSE;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Started", getDateStarted())
            .append("Completed", getDateCompleted())
            .append("Actor", getActor())
            .append("Work order", getWorkOrderTrackingNo())
            .append("Materials", materialStacks)
            .toString();
    }

    public List<RawMaterialStackInfo> getMaterialStacks() {
        return materialStacks;
    }

    public void setMaterialStacks(List<RawMaterialStackInfo> materialStacks) {
        this.materialStacks = materialStacks;
    }

}
