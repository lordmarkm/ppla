package com.ppla.core.dto.material;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class RawMaterialStackInfo extends BaseMaterialStackInfo<RawMaterialInfo> {

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Material", getMaterial())
            .append("Quantity", getQuantity())
            .toString();
    }

}
