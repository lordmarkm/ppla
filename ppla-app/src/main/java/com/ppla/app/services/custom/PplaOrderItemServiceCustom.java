package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.core.dto.PplaOrderItemInfo;

/**
 * @author Mark
 */
public interface PplaOrderItemServiceCustom {

    PplaOrderItemInfo findOneInfo(Long id);
    List<PplaOrderItemInfo> findAttachedInfo(String trackingNo);

}
