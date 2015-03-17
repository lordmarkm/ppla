package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.tyrael.commons.models.Sequence;

@Entity(name = "WO_SEQUENCE")
public class PplaWorkorderSequence extends Sequence {

    private static final String PADCHAR = "0";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "SEQUENCE")
    private Long sequence = 0l;

    @Override
    public String getTemporalPart() {
        return super.getTemporalPart();
    }

    @Override
    public String getSequencePart() {
        return StringUtils.leftPad("" + sequence, 8, PADCHAR);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Long getSequence() {
        return sequence;
    }

}
