package com.ppla.app.models.material;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ppla.core.reference.MaterialSource;


/**
 * @author mbmartinez
 */
@Entity(name = "PROCESS_MATERIAL")
@DiscriminatorValue("PROCESS")
public class ProcessMaterial extends PplaMaterial {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialSource source;

    public MaterialSource getSource() {
        return source;
    }

    public void setSource(MaterialSource source) {
        this.source = source;
    }

}
