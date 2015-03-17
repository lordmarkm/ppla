package com.ppla.core.dto.process;

import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

import com.baldy.commons.models.BaseBaldyInfo;
import com.ppla.core.dto.PplaUserInfo;
import com.ppla.core.dto.PplaWorkOrderInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
public abstract class BasePplaProcessInfo extends BaseBaldyInfo {

    protected DateTime dateStarted;
    protected DateTime dateCompleted;
    protected String turnaroundTime;
    protected PplaUserInfo actor;
    protected PplaUserInfo endActor;
    protected PplaWorkOrderInfo workOrder;
    protected String remarks;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", getId())
            .append("Work order", workOrder)
            .append("Started", dateStarted)
            .append("Completed", dateCompleted)
            .append("Turnaround time", turnaroundTime)
            .append("Actor", actor)
            .append("Remarks", remarks)
            .toString();
    }

    public abstract ProcessType getType();

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
    public PplaWorkOrderInfo getWorkOrder() {
        return workOrder;
    }
    public void setWorkOrder(PplaWorkOrderInfo workOrder) {
        this.workOrder = workOrder;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public PplaUserInfo getEndActor() {
        return endActor;
    }
    public void setEndActor(PplaUserInfo endActor) {
        this.endActor = endActor;
    }

    public String getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(String turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

}
