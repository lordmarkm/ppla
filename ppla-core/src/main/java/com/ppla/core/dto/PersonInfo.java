package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark
 */
public class PersonInfo {

    protected Long id;
    protected NameInfo name;
    protected String description;
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("Name", name)
            .append("Description", description)
            .toString();
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

    public NameInfo getName() {
        return name;
    }

    public void setName(NameInfo name) {
        this.name = name;
    }
}
