package com.ppla.core.dto.process;

import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

import com.baldy.commons.models.BaseBaldyInfo;
import com.ppla.core.dto.PersonInfo;
import com.ppla.core.dto.PplaUserInfo;

/**
 * @author mbmartinez
 */
public class BasePplaProcessInfo extends BaseBaldyInfo {

    private DateTime dateStarted;
    private DateTime dateCompleted;
    private PplaUserInfo actor;
    private String workOrderTrackingNo;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", getId())
            .append("Work order", workOrderTrackingNo)
            .append("Started", dateStarted)
            .append("Completed", dateCompleted)
            .append("Actor", actor)
            .toString();
    }

    public DateTime getDateStarted() {
        return dateStarted;
    }
    public void setDateStarted(DateTime dateStarted) {
        this.dateStarted = dateStarted;
    }
    public DateTime getDateCompleted() {
        return dateCompleted;
    }
    public void setDateCompleted(DateTime dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
    public PplaUserInfo getActor() {
        return actor;
    }
    public void setActor(PplaUserInfo actor) {
        this.actor = actor;
    }

    public String getWorkOrderTrackingNo() {
        return workOrderTrackingNo;
    }

    public void setWorkOrderTrackingNo(String workOrderTrackingNo) {
        this.workOrderTrackingNo = workOrderTrackingNo;
    }

}
