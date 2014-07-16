package com.ppla.app.models.process;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.material.ProcessMaterialStack;

/**
 * @author mbmartinez
 */
@Entity(name = "CUTTING_PROCESS")
@DiscriminatorValue("CUTTING")
public class CuttingProcess extends MachineProcess {

    private List<ProcessMaterialStack> materialsInput;
    private int productOut;

    public List<ProcessMaterialStack> getMaterialsInput() {
        return materialsInput;
    }
    public void setMaterialsInput(List<ProcessMaterialStack> materialsInput) {
        this.materialsInput = materialsInput;
    }
    public int getProductOut() {
        return productOut;
    }
    public void setProductOut(int productOut) {
        this.productOut = productOut;
    }

}
