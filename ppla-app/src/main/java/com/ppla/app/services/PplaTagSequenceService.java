package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaTagSequence;
import com.ppla.app.services.custom.PplaTagSequenceServiceCustom;

public interface PplaTagSequenceService extends JpaRepository<PplaTagSequence, Long>,
    PplaTagSequenceServiceCustom {

}
