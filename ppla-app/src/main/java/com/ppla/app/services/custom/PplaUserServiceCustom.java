package com.ppla.app.services.custom;

import com.ppla.core.dto.PplaUserInfo;

/**
 * @author mbmartinez
 */
public interface PplaUserServiceCustom {

    /**
     * IMPORTANT: This may return null.
     */
    PplaUserInfo findByUsernameInfo(String username);

    PplaUserInfo saveInfo(PplaUserInfo profile);

}
