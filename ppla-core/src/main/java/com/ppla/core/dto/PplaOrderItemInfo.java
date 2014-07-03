package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PplaOrderItemInfo {

    private Integer quantity;
    private ProductInfo product;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Quantity", quantity)
            .append("Product", product)
            .toString();
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public ProductInfo getProduct() {
        return product;
    }
    public void setProduct(ProductInfo product) {
        this.product = product;
    }

}
