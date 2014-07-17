package com.ppla.core.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Mark
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NameInfo {

    private String givenName;
    private String middleName;
    private String surname;

    @Override
    public String toString() {
        return surname + ", " + givenName + " " + (middleName != null ? middleName : "");
    }

    public String getToString() {
        return toString();
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
