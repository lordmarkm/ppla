package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.custom.PplaSalesOrderServiceCustom;

/**
 * @author Mark
 */
public interface PplaSalesOrderService extends PplaSalesOrderServiceCustom,
    JpaRepository<PplaSalesOrder, Long> {

    PplaSalesOrder findByTrackingNo(String trackingNo);

}
