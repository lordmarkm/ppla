package com.ppla.core.dto.process;

import java.util.List;

import com.ppla.core.dto.material.ProcessMaterialStackInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
public class ExtrusionProcessInfo extends MachineProcessInfo {

    private List<ProcessMaterialStackInfo> materialsIn;
    private List<ProcessMaterialStackInfo> materialsOut;

    @Override
    public ProcessType getType() {
        return ProcessType.EXTRUSION;
    }

    public List<ProcessMaterialStackInfo> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<ProcessMaterialStackInfo> materialsIn) {
        this.materialsIn = materialsIn;
    }

    public List<ProcessMaterialStackInfo> getMaterialsOut() {
        return materialsOut;
    }

    public void setMaterialsOut(List<ProcessMaterialStackInfo> materialsOut) {
        this.materialsOut = materialsOut;
    }

}
