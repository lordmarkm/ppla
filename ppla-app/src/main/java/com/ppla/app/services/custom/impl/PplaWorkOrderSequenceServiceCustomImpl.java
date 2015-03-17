package com.ppla.app.services.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaWorkorderSequence;
import com.ppla.app.services.PplaWorkOrderSequenceService;
import com.ppla.app.services.custom.PplaWorkOrderSequenceServiceCustom;

public class PplaWorkOrderSequenceServiceCustomImpl implements PplaWorkOrderSequenceServiceCustom {

    @Autowired
    private PplaWorkOrderSequenceService service;

    @Override
    public String next() {
        List<PplaWorkorderSequence> sequenceList = service.findAll();
        PplaWorkorderSequence sequence;
        if (sequenceList.isEmpty()) {
            sequence = service.save(new PplaWorkorderSequence());
        } else {
            sequence = sequenceList.get(0);
        }

        String next = sequence.next();
        sequence.setSequence(sequence.getSequence() + 1);
        service.save(sequence);

        return next;
    }

}
