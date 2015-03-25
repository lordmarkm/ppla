package com.ppla.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.tyrael.commons.models.Sequence;

@Entity(name = "TAG_SEQUENCE")
public class PplaTagSequence extends Sequence {

    private static final String PADCHAR = "0";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "SEQUENCE")
    private Long sequence = 0l;

    @Column(name = "LAST_TEMPORAL")
    private String lastTemporalPart;

    @Override
    protected void checkSequenceReset() {
        String currentTemporalPart = this.getTemporalPart();
        if (null != lastTemporalPart && !lastTemporalPart.equals(currentTemporalPart)) {
            sequence = 0l;
        }
        this.lastTemporalPart = currentTemporalPart;
    }

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
