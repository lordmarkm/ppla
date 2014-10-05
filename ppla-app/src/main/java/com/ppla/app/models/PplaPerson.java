package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.baldy.commons.models.proper.Person;

/**
 * @author Mark
 */
@Entity(name = "PPLA_PERSON")
public class PplaPerson extends Person {

    @Column(name = "LIST_ID")
    private String listId;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

}
