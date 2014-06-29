package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaProduct;

/**
 * 
 * @author Mark
 *
 */
public interface PplaProductService extends JpaRepository<PplaProduct, Long> {

}
