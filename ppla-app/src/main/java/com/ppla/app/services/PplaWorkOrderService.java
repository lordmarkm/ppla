package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaWorkOrder;

/**
 * @author Mark
 */
public interface PplaWorkOrderService extends JpaRepository<PplaWorkOrder, Long> {

}
