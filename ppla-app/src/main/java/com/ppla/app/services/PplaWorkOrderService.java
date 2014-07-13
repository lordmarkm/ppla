package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.services.custom.PplaWorkOrderServiceCustom;

/**
 * @author Mark
 */
public interface PplaWorkOrderService extends JpaRepository<PplaWorkOrder, Long>,
    PplaWorkOrderServiceCustom {

    PplaWorkOrder findByTrackingNo(String trackingNo);

}
