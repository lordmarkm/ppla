package com.ppla.core.dto.material;

import org.springframework.core.style.ToStringCreator;

import com.ppla.core.dto.BasePplaDto;

/**
 * @author mbmartinez
 */
public class BaseMaterialInfo extends BasePplaDto {

    private String unitOfMeasurement;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", id)
            .append("Name", name)
            .append("Description", description)
            .append("Unit of measurement", unitOfMeasurement)
            .toString();
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

}
