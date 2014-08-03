package com.ppla.app.models.machine;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.baldy.commons.models.BaseEntity;
import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
@Table(name = "MACHINE")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MACHINE_TYPE")
public abstract class Machine<P extends BasePplaProcess> extends BaseEntity {

    @Column(name = "PROCESS_TYPE")
    @Enumerated(EnumType.STRING)
    protected ProcessType type;

    @Column(name = "CODE")
    protected String code;

    @OneToOne
    @JoinColumn(name = "CURRENT_PROCESS")
    protected P currentProcess;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
