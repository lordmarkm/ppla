package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PersonInfo {

    private Long id;
    private NameInfo properName;
    private String description;
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("Name", properName)
            .append("Description", description)
            .toString();
    }

    public NameInfo getProperName() {
        return properName;
    }

    public void setProperName(NameInfo properName) {
        this.properName = properName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
