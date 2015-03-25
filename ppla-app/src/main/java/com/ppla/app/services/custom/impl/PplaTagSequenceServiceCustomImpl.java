package com.ppla.app.services.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaTagSequence;
import com.ppla.app.services.PplaTagSequenceService;
import com.ppla.app.services.custom.PplaTagSequenceServiceCustom;

public class PplaTagSequenceServiceCustomImpl implements PplaTagSequenceServiceCustom {

    @Autowired
    private PplaTagSequenceService service;

    @Override
    public String next() {
        List<PplaTagSequence> sequenceList = service.findAll();
        PplaTagSequence sequence;
        if (sequenceList.isEmpty()) {
            sequence = service.save(new PplaTagSequence());
        } else {
            sequence = sequenceList.get(0);
        }

        String next = sequence.next();
        sequence.setSequence(sequence.getSequence() + 1);
        service.save(sequence);

        return next + checkSum(next);
    }

    private int checkSum(String code){
        int val=0;
        for(int i=0;i<code.length();i++){
            val+=((int)Integer.parseInt(code.charAt(i)+""))*((i%2==0)?1:3);
        }

        int checksum_digit = 10 - (val % 10);
        if (checksum_digit == 10) checksum_digit = 0;

        return checksum_digit;
    }
}
