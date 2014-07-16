package com.ppla.core.dto.process;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.material.RawMaterialStackInfo;

/**
 * @author mbmartinez
 */
public class WarehouseProcessInfo extends BasePplaProcessInfo {

    private List<RawMaterialStackInfo> materialStacks;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Started", getDateStarted())
            .append("Completed", getDateCompleted())
            .append("Actor", getActor())
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
