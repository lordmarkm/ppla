package com.ppla.app.models.process;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ppla.app.models.material.ProcessMaterialStack;

/**
 * @author mbmartinez
 */
@Entity(name = "CUTTING_PROCESS")
@DiscriminatorValue("CUTTING")
public class CuttingProcess extends MachineProcess {

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProcessMaterialStack> materialsInput;

    @Column(name = "OUTPUT")
    private BigDecimal productOut;

    public List<ProcessMaterialStack> getMaterialsInput() {
        return materialsInput;
    }
    public void setMaterialsInput(List<ProcessMaterialStack> materialsInput) {
        this.materialsInput = materialsInput;
    }
    public BigDecimal getProductOut() {
        return productOut;
    }
    public void setProductOut(BigDecimal productOut) {
        this.productOut = productOut;
    }

}
