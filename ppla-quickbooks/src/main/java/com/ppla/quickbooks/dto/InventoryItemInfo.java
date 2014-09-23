package com.ppla.quickbooks.dto;

import org.joda.time.DateTime;

import com.ppla.quickbooks.reference.PplaInventoryType;

/**
 * @author Mark
 */
public class InventoryItemInfo {
    private PplaInventoryType type;
    private String unitOfMeasurement;
    private String listId;
    private DateTime timeModified;
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
}
