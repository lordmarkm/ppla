package com.ppla.app.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.services.custom.PplaWorkOrderServiceCustom;

/**
 * @author Mark
 */
public interface PplaWorkOrderService extends JpaRepository<PplaWorkOrder, Long>,
    PplaWorkOrderServiceCustom {

    List<PplaWorkOrder> findBySalesOrder(PplaSalesOrder salesOrder);

}
