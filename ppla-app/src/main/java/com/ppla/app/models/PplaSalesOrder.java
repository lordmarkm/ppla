package com.ppla.app.models;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.tyrael.process.mgt.models.order.SalesOrder;

/**
 * @author Mark
 */
@Entity(name = "SALES_ORDER")
public class PplaSalesOrder extends SalesOrder<PplaOrderItem, PplaPerson> {

    @Column(name = "TXN_NO", nullable = false)
    private BigInteger txnNumber;

    @Column(name = "EDIT_SEQ", nullable = false)
    private String editSequence;

    @Column(name = "MODIFIED", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime timeModified;

    @Override
    public void setItems(List<PplaOrderItem> items) {
        super.setItems(items);
    }

    @Override
    public List<PplaOrderItem> getItems() {
        return super.getItems();
    }

    public String getEditSequence() {
        return editSequence;
    }

    public void setEditSequence(String editSequence) {
        this.editSequence = editSequence;
    }

    public BigInteger getTxnNumber() {
        return txnNumber;
    }

    public void setTxnNumber(BigInteger txnNumber) {
        this.txnNumber = txnNumber;
    }

    public DateTime getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(DateTime timeModified) {
        this.timeModified = timeModified;
    }

}
