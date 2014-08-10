package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.ppla.app.reference.PplaUserType;

/**
 * @author Mark
 */
@Entity
@Table(name = "PPLA_USER")
public class PplaUser extends PplaPerson {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PplaUserType type;

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

    public PplaUserType getType() {
        return type;
    }

    public void setType(PplaUserType type) {
        this.type = type;
    }

}
