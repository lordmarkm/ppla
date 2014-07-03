package com.ppla.app.models;

import java.util.List;

import javax.persistence.Entity;

import com.tyrael.process.mgt.models.order.SalesOrder;

/**
 * 
 * @author Mark
 *
 */
@Entity(name = "SALES_ORDER")
public class PplaSalesOrder extends SalesOrder<PplaOrderItem, PplaPerson> {

    @Override
    public void setItems(List<PplaOrderItem> items) {
        super.setItems(items);
    }

    @Override
    public List<PplaOrderItem> getItems() {
        return super.getItems();
    }

}
