package com.ppla.core.dto.material;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class ProcessMaterialInfo extends BaseMaterialInfo {

    private String tag;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", getId())
            .append("Name", getName())
            .append("Description", getDescription())
            .append("Unit of measurement", getUnitOfMeasurement())
            .append("Tag", tag)
            .toString();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
