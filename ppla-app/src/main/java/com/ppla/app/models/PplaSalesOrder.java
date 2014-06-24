package com.ppla.app.models;

import javax.persistence.Entity;

import com.tyrael.process.mgt.models.order.SalesOrder;

/**
 * 
 * @author Mark
 *
 */
@Entity(name = "SALES_ORDER")
public class PplaSalesOrder extends SalesOrder<PplaOrderItem> {

}
