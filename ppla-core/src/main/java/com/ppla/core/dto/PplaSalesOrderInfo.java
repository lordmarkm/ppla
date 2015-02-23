package com.ppla.core.dto;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PplaSalesOrderInfo {

    private String trackingNo;
    private String purchaseOrderNo;
    private PersonInfo customer;
    private String shipTo;
    private List<PplaOrderItemInfo> orderItems;
    private DateTime dateCreated;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Tracking No.", trackingNo)
            .append("Purchase Order No.", purchaseOrderNo)
            .append("Customer", customer)
            .append("Ship to", shipTo)
            .append("Items", orderItems)
            .append("Date created", dateCreated)
            .toString();
    }

    public String getTrackingNo() {
        return trackingNo;
    }
    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }
    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }
    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }
    public PersonInfo getCustomer() {
        return customer;
    }
    public void setCustomer(PersonInfo customer) {
        this.customer = customer;
    }
    public String getShipTo() {
        return shipTo;
    }
    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }
    public List<PplaOrderItemInfo> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<PplaOrderItemInfo> items) {
        this.orderItems = items;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

}
