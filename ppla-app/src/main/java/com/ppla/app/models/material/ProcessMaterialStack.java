package com.ppla.app.models.material;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.tyrael.process.mgt.models.material.MaterialStack;

/**
 * @author Mark
 */
@Entity(name = "PROCESS_MATERIAL_STACK")
public class ProcessMaterialStack extends MaterialStack<ProcessMaterial> {

    @Column(name = "TAG")
    private String tag;

    @Column(name = "WORK_ORDER_TRACKING_NO")
    private String workorderTrackingNo;

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
