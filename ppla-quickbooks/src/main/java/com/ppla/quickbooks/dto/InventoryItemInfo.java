package com.ppla.quickbooks.dto;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.BasePplaDto;
import com.ppla.quickbooks.reference.PplaInventoryType;

/**
 * @author Mark
 */
public class InventoryItemInfo extends BasePplaDto {

    private PplaInventoryType type;
    private String unitOfMeasurement;
    private BigDecimal quantityOnHand;
    private String listId;
    private DateTime timeModified;
    private String editSequence;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("type", type)
            .append("uom", unitOfMeasurement)
            .append("qty", quantityOnHand)
            .append("listId", listId)
            .append("modified (qb)", timeModified)
            .append("editSequence", editSequence)
            .toString();
    }
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
