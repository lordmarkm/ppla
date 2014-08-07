package com.ppla.core.dto;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PplaWorkOrderInfo {

    private Integer quantity = 0;
    private String trackingNo;
    private String status;
    private DateTime dateCreated;
    private DateTime dateCompleted;

    //Not saved in entity
    List<PplaOrderItemInfo> orderItems;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Tracking no", trackingNo)
            .append("Quantity", quantity)
            .append("Status", status)
            .append("Created", dateCreated)
            .append("Completed", dateCompleted)
            .toString();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public DateTime getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(DateTime dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public void setOrderItems(List<PplaOrderItemInfo> orderItems) {
        this.orderItems = orderItems;
    }

    public List<PplaOrderItemInfo> getOrderItems() {
        return orderItems;
    }

}
