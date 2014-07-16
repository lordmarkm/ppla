package com.ppla.core.dto.material;

import java.math.BigDecimal;

/**
 * @author mbmartinez
 * @param <M>
 */
public abstract class BaseMaterialStackInfo<M extends BaseMaterialInfo> {

    private M material;
    private BigDecimal amount;

    public M getMaterial() {
        return material;
    }
    public void setMaterial(M material) {
        this.material = material;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
