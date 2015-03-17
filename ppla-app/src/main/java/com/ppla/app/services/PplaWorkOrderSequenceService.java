package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaWorkorderSequence;
import com.ppla.app.services.custom.PplaWorkOrderSequenceServiceCustom;

public interface PplaWorkOrderSequenceService extends JpaRepository<PplaWorkorderSequence, Long>,
    PplaWorkOrderSequenceServiceCustom {

}
