package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class PplaUserInfo extends PersonInfo {

    protected String username;
    protected String code;
    protected String type = "OPERATOR";

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("Name", name)
            .append("Description", description)
            .append("Username", username)
            .append("Code", code)
            .append("Type", type)
            .toString();
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
