package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.models.material.RawMaterialStack;

@Entity(name = "MIXING_PROCESS")
@DiscriminatorValue("MIXING")
public class MixingProcess extends MachineProcess<RawMaterialStack> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialOut;

    public List<ProcessMaterialStack> getMaterialOut() {
        return materialOut;
    }

    public void setMaterialOut(List<ProcessMaterialStack> materialOut) {
        this.materialOut = materialOut;
    }

}
