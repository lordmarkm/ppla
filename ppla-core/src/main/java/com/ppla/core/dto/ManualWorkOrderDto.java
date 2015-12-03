package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * 
 * @author Mark Martinez, create Dec 3, 2015
 *
 */
public class ManualWorkOrderDto {

    private ProductInfo product;
    private int quantity;
    
    public String toString() {
        return new ToStringCreator(this)
            .append("prod", product)
            .append("qty", quantity)
            .toString();
    }

    public ProductInfo getProduct() {
        return product;
    }
    public void setProduct(ProductInfo product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
