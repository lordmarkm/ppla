package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PersonInfo {

    private String name;
    private String description;
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("Name", name)
            .append("Description", description)
            .toString();
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
