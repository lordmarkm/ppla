package com.ppla.core.dto.machine;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.BasePplaDto;
import com.ppla.core.dto.process.MachineProcessInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author Mark
 */
public class MachineInfo extends BasePplaDto {

    private MachineProcessInfo currentProcess;
    private ProcessType type;
    private String code;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Current process", currentProcess)
            .append("Type", type)
            .append("Code", code)
            .toString();
    }

    @JsonBackReference
    public MachineProcessInfo getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(MachineProcessInfo currentProcess) {
        this.currentProcess = currentProcess;
    }

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
