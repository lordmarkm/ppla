package com.ppla.core.dto.report;

/**
 * @author mbmartinez
 */
public class RollTagReportInfo {

    private String tag;
    private String workorderTrackingNo;

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

}
