package com.ppla.app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "RAW_MATERIAL")
@DiscriminatorValue("RAW")
public class RawMaterial extends PplaMaterial {

}