package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.tyrael.process.mgt.models.order.OrderItem;

/**
 * @author Mark
 */
@Entity(name = "ORDER_ITEM")
public class PplaOrderItem extends OrderItem<PplaSalesOrder, PplaProduct, PplaWorkOrder> {

    @Column(name = "TXN_LINE_ID", nullable = false)
    private String txnLineId;

    public String getTxnLineId() {
        return txnLineId;
    }

    public void setTxnLineId(String txnLineId) {
        this.txnLineId = txnLineId;
    }

}
