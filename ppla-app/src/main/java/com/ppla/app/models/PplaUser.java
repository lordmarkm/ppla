package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "PPLA_USER")
public class PplaUser extends PplaPerson {

    @Column(unique = true)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
