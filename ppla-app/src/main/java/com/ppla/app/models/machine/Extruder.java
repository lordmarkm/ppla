package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.process.ExtrusionProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("EXTRUSION")
public class Extruder extends Machine<ExtrusionProcess> {

}
