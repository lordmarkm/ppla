package com.ppla.core.dto.machine;

import java.util.List;

import com.ppla.core.dto.process.ExtrusionProcessInfo;

/**
 * @author mbmartinez
 */
public class ExtruderInfo extends MachineInfo {

    private List<ExtrusionProcessInfo> staged;

    public List<ExtrusionProcessInfo> getStaged() {
        return staged;
    }

    public void setStaged(List<ExtrusionProcessInfo> staged) {
        this.staged = staged;
    }

}
