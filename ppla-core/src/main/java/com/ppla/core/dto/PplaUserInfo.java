package com.ppla.core.dto;

import org.springframework.core.style.ToStringCreator;

/**
 * @author mbmartinez
 */
public class PplaUserInfo extends PersonInfo {

    private String username;
    private String code;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", getId())
            .append("Name", getProperName())
            .append("Description", getDescription())
            .append("Username", username)
            .append("Code", code)
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
}
