package com.ppla.app.models;

import javax.persistence.Entity;

import com.tyrael.process.mgt.models.order.WorkOrder;

/**
 * 
 * @author Mark
 *
 */
@Entity(name = "WORK_ORDER")
public class PplaWorkOrder extends WorkOrder<PplaSalesOrder> {

}
