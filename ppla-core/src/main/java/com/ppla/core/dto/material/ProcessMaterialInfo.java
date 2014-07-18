package com.ppla.core.dto.material;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.reference.MaterialSource;

/**
 * @author mbmartinez
 */
public class ProcessMaterialInfo extends BaseMaterialInfo {

    private MaterialSource source;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", getId())
            .append("Name", getName())
            .append("Description", getDescription())
            .append("Unit of measurement", getUnitOfMeasurement())
            .append("Source", source)
            .toString();
    }

    public MaterialSource getSource() {
        return source;
    }

    public void setSource(MaterialSource source) {
        this.source = source;
    }


}
