package com.ppla.app.models.material;

import javax.persistence.Entity;

import com.tyrael.process.mgt.models.material.MaterialStack;

@Entity(name = "RAW_MATERIAL_STACK")
public class RawMaterialStack extends MaterialStack<RawMaterial> {

}
