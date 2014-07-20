package com.ppla.app.models.machine;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.baldy.commons.models.BaseBaldyEntity;
import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
@Table(name = "MACHINE")
@MappedSuperclass
public abstract class Machine<P extends BasePplaProcess> extends BaseBaldyEntity {

    @Column
    @Enumerated(EnumType.STRING)
    public ProcessType type;

    @OneToOne
    @JoinColumn(name = "CURRENT_PROCESS")
    public P currentProcess;

    public ProcessType getType() {
        return type;
    }

    public void setType(ProcessType type) {
        this.type = type;
    }

    public P getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(P currentProcess) {
        this.currentProcess = currentProcess;
    }

}
