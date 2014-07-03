package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaPerson;

/**
 * @author Mark
 */
public interface PplaPersonService extends JpaRepository<PplaPerson, Long> {

}
