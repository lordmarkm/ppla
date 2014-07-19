package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.tyrael.process.mgt.models.product.Product;

/**
 * @author Mark
 */
@Entity(name = "PRODUCT")
public class PplaProduct extends Product {

    @Column(name = "DELETED")
    private Boolean deleted = false;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
