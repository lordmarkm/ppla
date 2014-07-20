package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.process.PrintingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("PRINTING")
public class Printer extends Machine<PrintingProcess> {

}
