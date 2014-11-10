package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.tyrael.commons.models.Product;

/**
 * @author Mark
 */
@Entity(name = "PRODUCT")
public class PplaProduct extends Product {

    @Column(name = "LIST_ID")
    private String inventoryItemListId;

    public String getInventoryItemListId() {
        return inventoryItemListId;
    }

    public void setInventoryItemListId(String inventoryItemListId) {
        this.inventoryItemListId = inventoryItemListId;
    }

}
