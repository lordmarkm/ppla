package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class ProductInfo {

    private String id;
    private String name;
    private String description;
    private String unitOfMeasurement;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("ID", id)
            .append("Name", name)
            .append("Description", description)
            .append("Unit of Measurement", unitOfMeasurement)
            .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
}
