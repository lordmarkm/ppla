package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaUser;
import com.ppla.app.services.custom.PplaUserServiceCustom;

/**
 * @author mbmartinez
 */
public interface PplaUserService extends JpaRepository<PplaUser, Long>, PplaUserServiceCustom {

    PplaUser findByUsername(String username);

}
