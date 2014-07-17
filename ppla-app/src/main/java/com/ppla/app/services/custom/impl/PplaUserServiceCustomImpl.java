package com.ppla.app.services.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaUser;
import com.ppla.app.services.PplaUserService;
import com.ppla.app.services.custom.PplaUserServiceCustom;
import com.ppla.core.dto.PplaUserInfo;

public class PplaUserServiceCustomImpl extends MappingService<PplaUser, PplaUserInfo>
    implements PplaUserServiceCustom {

    @Autowired
    private PplaUserService service;

    public PplaUserServiceCustomImpl() {
        super(PplaUser.class, PplaUserInfo.class);
    }

    @Override
    public PplaUserInfo findByUsernameInfo(String username) {
        PplaUser user = service.findByUsername(username);
        return null == user ? null : toDto(user);
    }

    @Override
    public PplaUserInfo saveInfo(PplaUserInfo profile) {
        return toDto(service.save(toEntity(profile)));
    }

}
