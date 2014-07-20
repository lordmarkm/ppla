package com.ppla.core.dto.material;

import java.math.BigDecimal;

/**
 * @author mbmartinez
 * @param <M>
 */
public abstract class BaseMaterialStackInfo<M extends BaseMaterialInfo> {

    protected Long id;
    protected M material;
    protected BigDecimal quantity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
