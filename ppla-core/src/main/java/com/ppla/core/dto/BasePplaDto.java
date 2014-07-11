package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class BasePplaDto {

    private Long id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("name", name)
            .append("description", description)
            .toString();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

}
