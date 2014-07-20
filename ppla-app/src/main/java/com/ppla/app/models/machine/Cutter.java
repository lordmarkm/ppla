package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.process.CuttingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("CUTTING")
public class Cutter extends Machine<CuttingProcess> {

}
