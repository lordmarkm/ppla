package com.ppla.app.models.machine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ppla.app.models.process.MixingProcess;

/**
 * @author Mark
 */
@Entity
@DiscriminatorValue("MIXER")
public class Mixer extends Machine<MixingProcess> {

}
