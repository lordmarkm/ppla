package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.tyrael.process.mgt.models.material.Material;

@MappedSuperclass
@Table(name = "MATERIAL")
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
