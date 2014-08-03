package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Mark
 */
@Entity(name = "PPLA_USER")
public class PplaUser extends PplaPerson {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String code;

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
