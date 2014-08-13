package com.ppla.app.models.process;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.machine.Mixer;
import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.models.material.RawMaterialStack;

@Entity(name = "MIXING_PROCESS")
@DiscriminatorValue("MIXING")
public class MixingProcess extends MachineProcess<Mixer, RawMaterialStack> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<RawMaterialStack> materialsIn;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialsOut;

    @Column(name = "NET_WT")
    private BigDecimal materialsOutNetWt;

    @ManyToMany
    @JoinTable(
        name = "MIXING_PROCESS_BATCH",
        joinColumns = {@JoinColumn(name = "PROCESS_ID")},
        inverseJoinColumns = {@JoinColumn(name = "WORK_ORDER_ID")}
    )
    private List<PplaWorkOrder> workOrders;

    public List<ProcessMaterialStack> getMaterialsOut() {
        return materialsOut;
    }

    public void setMaterialsOut(List<ProcessMaterialStack> materialsOut) {
        this.materialsOut = materialsOut;
    }

    public BigDecimal getMaterialsOutNetWt() {
        return materialsOutNetWt;
    }

    public void setMaterialOutNetWt(BigDecimal materialsOutNetWt) {
        this.materialsOutNetWt = materialsOutNetWt;
    }

    public List<PplaWorkOrder> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<PplaWorkOrder> workOrders) {
        this.workOrders = workOrders;
    }

    public void setMaterialsOutNetWt(BigDecimal materialsOutNetWt) {
        this.materialsOutNetWt = materialsOutNetWt;
    }

    public List<RawMaterialStack> getMaterialsIn() {
        return materialsIn;
    }

    public void setMaterialsIn(List<RawMaterialStack> materialsIn) {
        this.materialsIn = materialsIn;
    }

}
