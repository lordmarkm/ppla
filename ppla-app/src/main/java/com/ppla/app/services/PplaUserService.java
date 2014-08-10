package com.ppla.app.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaUser;
import com.ppla.app.reference.PplaUserType;
import com.ppla.app.services.custom.PplaUserServiceCustom;

/**
 * @author mbmartinez
 */
public interface PplaUserService extends JpaRepository<PplaUser, Long>, PplaUserServiceCustom {

    PplaUser findByUsername(String username);
    PplaUser findByCode(String code);
    List<PplaUser> findByType(PplaUserType enumType);

}
