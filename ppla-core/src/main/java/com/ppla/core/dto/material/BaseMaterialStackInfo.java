package com.ppla.core.dto.material;

import java.math.BigDecimal;

/**
 * @author mbmartinez
 * @param <M>
 */
public abstract class BaseMaterialStackInfo<M extends BaseMaterialInfo> {

    private M material;
    private BigDecimal quantity;

    public M getMaterial() {
        return material;
    }
    public void setMaterial(M material) {
        this.material = material;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}
