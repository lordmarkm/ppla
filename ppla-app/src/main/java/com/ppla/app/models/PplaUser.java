package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ppla.app.reference.PplaUserType;

/**
 * @author Mark
 */
@Entity(name = "PPLA_USER")
public class PplaUser extends PplaPerson {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PplaUserType type;

    /**
     * Fluff
     */
    @Column(name = "TITLE")
    private String title;

    @Column(name = "REPORTS_TO")
    private String reportsTo;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

}
