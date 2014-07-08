package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PplaWorkOrderInfo {

    private PplaOrderItemInfo orderItem;
    private Integer quantity = 0;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Order item", orderItem)
            .append("Quantity", quantity)
            .toString();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PplaOrderItemInfo getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(PplaOrderItemInfo orderItem) {
        this.orderItem = orderItem;
    }

}
