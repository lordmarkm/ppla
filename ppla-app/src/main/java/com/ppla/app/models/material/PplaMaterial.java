package com.ppla.app.models.material;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.tyrael.process.mgt.models.material.Material;

@MappedSuperclass
@Table(name = "MATERIAL")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "MATERIAL_TYPE")
public abstract class PplaMaterial extends Material {

    @Column
    private Boolean deleted = Boolean.FALSE;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
