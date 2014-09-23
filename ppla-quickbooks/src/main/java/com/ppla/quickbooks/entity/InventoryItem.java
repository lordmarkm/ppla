package com.ppla.quickbooks.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.baldy.commons.models.BaseBaldyEntity;
import com.ppla.quickbooks.reference.PplaInventoryType;

/**
 * @author Mark
 */
@Entity(name = "INVENTORY_ITEM")
public class InventoryItem extends BaseBaldyEntity {

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private PplaInventoryType type = PplaInventoryType.UNCLASSIFIED;

    @Column(name = "UOM")
    private String unitOfMeasurement;

    @Column(name = "QTY")
    private BigDecimal quantityOnHand;

    @NaturalId
    @Column(name = "LIST_ID")
    private String listId;

    @Column(name = "MODIFIED")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime timeModified;

    @Column(name = "EDIT_SEQUENCE")
    private String editSequence;

    public PplaInventoryType getType() {
        return type;
    }

    public void setType(PplaInventoryType type) {
        this.type = type;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public DateTime getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(DateTime timeModified) {
        this.timeModified = timeModified;
    }

    public String getEditSequence() {
        return editSequence;
    }

    public void setEditSequence(String editSequence) {
        this.editSequence = editSequence;
    }

    public BigDecimal getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
