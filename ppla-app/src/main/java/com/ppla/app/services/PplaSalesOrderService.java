package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaSalesOrder;

/**
 * @author Mark
 */
public interface PplaSalesOrderService extends JpaRepository<PplaSalesOrder, Long> {

    public PplaSalesOrder findByTrackingNo(String trackingNo);

}
