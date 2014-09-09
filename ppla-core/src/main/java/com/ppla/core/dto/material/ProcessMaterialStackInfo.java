package com.ppla.core.dto.material;

import org.springframework.core.style.ToStringCreator;

public class ProcessMaterialStackInfo extends BaseMaterialStackInfo<ProcessMaterialInfo> {

    private String tag;
    private String workorderTrackingNo;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", id)
            .append("Material", material)
            .append("Quantity", quantity)
            .append("Tag", tag)
            .append("workorderTrackingNo", workorderTrackingNo)
            .toString();
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getWorkorderTrackingNo() {
        return workorderTrackingNo;
    }

    public void setWorkorderTrackingNo(String workorderTrackingNo) {
        this.workorderTrackingNo = workorderTrackingNo;
    }

}
