package com.ppla.app.models.material;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * @author mbmartinez
 */
@Entity(name = "PROCESS_MATERIAL")
@DiscriminatorValue("PROCESS")
public class ProcessMaterial extends PplaMaterial {

}
