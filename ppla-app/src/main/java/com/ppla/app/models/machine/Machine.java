package com.ppla.app.models.machine;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.baldy.commons.models.BaseEntity;
import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
@Entity(name = "MACHINE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "MACHINE_TYPE")
public abstract class Machine<P extends BasePplaProcess> extends BaseEntity {

    @Column(name = "PROCESS_TYPE")
    @Enumerated(EnumType.STRING)
    protected ProcessType type;

    @Column(name = "CODE")
    protected String code;

    public abstract P getCurrentProcess();
    public abstract void setCurrentProcess(P process);

    public ProcessType getType() {
        return type;
    }

    public void setType(ProcessType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
