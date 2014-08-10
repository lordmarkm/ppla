package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.core.dto.PplaUserInfo;

/**
 * @author mbmartinez
 */
public interface PplaUserServiceCustom {

    /**
     * IMPORTANT: This may return null.
     */
    PplaUserInfo findByUsernameInfo(String username);
    PplaUserInfo findByCodeInfo(String code);
    List<PplaUserInfo> findByTypeInfo(String type);

    PplaUserInfo saveInfo(PplaUserInfo profile);

}
