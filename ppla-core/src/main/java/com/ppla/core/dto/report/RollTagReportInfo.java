package com.ppla.core.dto.report;

/**
 * @author mbmartinez
 */
public class RollTagReportInfo {

    private String tag;
    private String workorderTrackingNo;
    private String product;
    private String productDescription;

    private String actor;
    private String dateStarted;
    private String endActor;
    private String dateCompleted;
    private String remarks;

    public String getWorkorderTrackingNo() {
        return workorderTrackingNo;
    }
    public void setWorkorderTrackingNo(String workorderTrackingNo) {
        this.workorderTrackingNo = workorderTrackingNo;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getActor() {
        return actor;
    }
    public void setActor(String actor) {
        this.actor = actor;
    }
    public String getDateStarted() {
        return dateStarted;
    }
    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }
    public String getEndActor() {
        return endActor;
    }
    public void setEndActor(String endActor) {
        this.endActor = endActor;
    }
    public String getDateCompleted() {
        return dateCompleted;
    }
    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
