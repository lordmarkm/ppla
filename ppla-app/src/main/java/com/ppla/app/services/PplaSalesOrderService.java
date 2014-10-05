package com.ppla.app.services;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.services.custom.PplaSalesOrderServiceCustom;

/**
 * @author Mark
 */
public interface PplaSalesOrderService extends PplaSalesOrderServiceCustom,
    JpaRepository<PplaSalesOrder, Long> {

    /**
     * This is how PPLA MES tracks its own sales orders.
     */
    PplaSalesOrder findByTrackingNo(String trackingNo);
    
    /**
     * This is how we match our sales orders with the incoming SOs from Quickbooks.
     */
    PplaSalesOrder findByTxnNumber(BigInteger txnNumber);

}
