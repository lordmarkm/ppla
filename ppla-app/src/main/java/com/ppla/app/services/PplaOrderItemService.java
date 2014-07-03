package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaOrderItem;

public interface PplaOrderItemService extends JpaRepository<PplaOrderItem, Long> {

}
