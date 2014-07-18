package com.ppla.app.models.material;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ppla.core.reference.MaterialSource;


@Entity(name = "RAW_MATERIAL")
@DiscriminatorValue("RAW")
public class RawMaterial extends PplaMaterial {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialSource source = MaterialSource.RAW;

    public MaterialSource getSource() {
        return source;
    }

    public void setSource(MaterialSource source) {
        this.source = source;
    }

}
