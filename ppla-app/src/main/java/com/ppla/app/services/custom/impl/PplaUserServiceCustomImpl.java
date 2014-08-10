package com.ppla.app.services.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.ppla.app.models.PplaUser;
import com.ppla.app.reference.PplaUserType;
import com.ppla.app.services.PplaUserService;
import com.ppla.app.services.custom.PplaUserServiceCustom;
import com.ppla.core.dto.PplaUserInfo;
import com.tyrael.commons.mapper.service.MappingService;

public class PplaUserServiceCustomImpl extends MappingService<PplaUser, PplaUserInfo>
    implements PplaUserServiceCustom {

    @Autowired
    private PplaUserService service;

    @Override
    public PplaUserInfo findByUsernameInfo(String username) {
        PplaUser user = service.findByUsername(username);
        return null == user ? null : toDto(user);
    }

    @Override
    public PplaUserInfo findByCodeInfo(String code) {
        PplaUser user = service.findByCode(code);
        return null == user ? null : toDto(user);
    }

    @Override
    public List<PplaUserInfo> findByTypeInfo(String type) {
        PplaUserType enumType = PplaUserType.valueOf(type);
        return toDto(service.findByType(enumType));
    }

    @Override
    public PplaUserInfo saveInfo(PplaUserInfo profile) {
        return toDto(service.save(toEntity(profile)));
    }

}
