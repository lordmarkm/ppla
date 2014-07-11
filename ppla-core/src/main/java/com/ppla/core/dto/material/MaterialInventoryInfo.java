package com.ppla.core.dto.material;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.google.common.collect.Lists;

/**
 * @author mbmartinez
 */
public class MaterialInventoryInfo {

    private List<RawMaterialInfo> rawMaterials = Lists.newArrayList();
    private List<ProcessMaterialInfo> procMaterials = Lists.newArrayList();

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Raw materials count", rawMaterials.size())
            .append("Process materials count", procMaterials.size())
            .toString();
    }

    public List<RawMaterialInfo> getRawMaterials() {
        return rawMaterials;
    }

    public List<ProcessMaterialInfo> getProcMaterials() {
        return procMaterials;
    }
}
