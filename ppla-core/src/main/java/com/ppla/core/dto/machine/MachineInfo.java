package com.ppla.core.dto.machine;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.BasePplaDto;
import com.ppla.core.reference.ProcessType;

/**
 * @author Mark
 */
public class MachineInfo extends BasePplaDto {

    private Long currentProcessId;
    private ProcessType type;
    private String code;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Current process id", currentProcessId)
            .append("Type", type)
            .append("Code", code)
            .toString();
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

    public Long getCurrentProcessId() {
        return currentProcessId;
    }

    public void setCurrentProcessId(Long currentProcessId) {
        this.currentProcessId = currentProcessId;
    }

}
