package com.ppla.app.models;

import javax.persistence.Entity;

import com.tyrael.process.mgt.models.order.OrderItem;

/**
 * @author Mark
 */
@Entity(name = "ORDER_ITEM")
public class PplaOrderItem extends OrderItem<PplaSalesOrder, PplaProduct> {

}
