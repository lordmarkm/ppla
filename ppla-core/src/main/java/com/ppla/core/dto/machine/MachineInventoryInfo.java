package com.ppla.core.dto.machine;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class MachineInventoryInfo {

    private List<MachineInfo> mixers;
    private List<MachineInfo> extruders;
    private List<MachineInfo> printers;
    private List<MachineInfo> cutters;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Mixers", mixers)
            .append("Extruders", extruders)
            .append("Printers", printers)
            .append("Cutters", cutters)
            .toString();
    }

    public List<MachineInfo> getMixers() {
        return mixers;
    }
    public void setMixers(List<MachineInfo> mixers) {
        this.mixers = mixers;
    }
    public List<MachineInfo> getExtruders() {
        return extruders;
    }
    public void setExtruders(List<MachineInfo> extruders) {
        this.extruders = extruders;
    }
    public List<MachineInfo> getPrinters() {
        return printers;
    }
    public void setPrinters(List<MachineInfo> printers) {
        this.printers = printers;
    }
    public List<MachineInfo> getCutters() {
        return cutters;
    }
    public void setCutters(List<MachineInfo> cutters) {
        this.cutters = cutters;
    }

}
