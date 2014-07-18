package com.ppla.core.dto.material;

import java.math.BigDecimal;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.reference.MaterialSource;

/**
 * @author mbmartinez
 */
public class MaterialBalanceStackInfo {

    private BaseMaterialInfo material;
    private MaterialSource source;
    private BigDecimal quantityWithdrawn;
    private BigDecimal quantityConsumed;
    private BigDecimal quantityRemaining;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Material", material)
            .append("Source", source)
            .append("Withdrawn", quantityWithdrawn)
            .append("Consumed", quantityConsumed)
            .append("Remaining", quantityRemaining)
            .toString();
    }

    public BaseMaterialInfo getMaterial() {
        return material;
    }
    public void setMaterial(BaseMaterialInfo material) {
        this.material = material;
    }
    public MaterialSource getSource() {
        return source;
    }
    public void setSource(MaterialSource source) {
        this.source = source;
    }
    public BigDecimal getQuantityWithdrawn() {
        return quantityWithdrawn;
    }
    public void setQuantityWithdrawn(BigDecimal quantityWithdrawn) {
        this.quantityWithdrawn = quantityWithdrawn;
    }
    public BigDecimal getQuantityRemaining() {
        return quantityRemaining;
    }
    public void setQuantityRemaining(BigDecimal quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }
    public BigDecimal getQuantityConsumed() {
        return quantityConsumed;
    }
    public void setQuantityConsumed(BigDecimal quantityConsumed) {
        this.quantityConsumed = quantityConsumed;
    }

}
