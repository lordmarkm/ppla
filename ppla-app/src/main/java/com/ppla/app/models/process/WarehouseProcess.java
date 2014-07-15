package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.material.RawMaterialStack;

@Entity(name = "WAREHOUSE_PROCESS")
@DiscriminatorValue("WAREHOUSE")
public class WarehouseProcess extends BasePplaProcess {

    @OneToMany(cascade = CascadeType.ALL)
    private List<RawMaterialStack> materialStacks;

    public List<RawMaterialStack> getMaterialStacks() {
        return materialStacks;
    }

    public void setMaterialStacks(List<RawMaterialStack> materialStacks) {
        this.materialStacks = materialStacks;
    }

}
