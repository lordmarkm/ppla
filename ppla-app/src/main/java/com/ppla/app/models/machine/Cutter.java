package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.process.CuttingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("CUTTER")
public class Cutter extends Machine<CuttingProcess> {

}
