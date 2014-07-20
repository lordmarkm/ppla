package com.ppla.app.models.process;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.machine.Mixer;
import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.models.material.RawMaterialStack;

@Entity(name = "MIXING_PROCESS")
@DiscriminatorValue("MIXING")
public class MixingProcess extends MachineProcess<Mixer, RawMaterialStack> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialsOut;

    @Column(name = "NET_WT", nullable = false)
    private BigDecimal materialsOutNetWt;

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

}
