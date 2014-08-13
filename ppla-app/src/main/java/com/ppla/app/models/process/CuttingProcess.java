package com.ppla.app.models.process;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.machine.Cutter;
import com.ppla.app.models.material.ProcessMaterialStack;

/**
 * @author mbmartinez
 */
@Entity(name = "CUTTING_PROCESS")
@DiscriminatorValue("CUTTING")
public class CuttingProcess extends MachineProcess<Cutter, ProcessMaterialStack> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialsIn;
    
    @Column(name = "OUTPUT")
    private BigDecimal productOut;

    public BigDecimal getProductOut() {
        return productOut;
    }
    public void setProductOut(BigDecimal productOut) {
        this.productOut = productOut;
    }
    public List<ProcessMaterialStack> getMaterialsIn() {
        return materialsIn;
    }
    public void setMaterialsIn(List<ProcessMaterialStack> materialsIn) {
        this.materialsIn = materialsIn;
    }

}
