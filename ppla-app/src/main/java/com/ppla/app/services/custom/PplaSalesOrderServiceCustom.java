package com.ppla.app.services.custom;

import org.springframework.data.domain.Pageable;

import com.ppla.core.dto.PplaSalesOrderInfo;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author Mark
 */
public interface PplaSalesOrderServiceCustom {

    PplaSalesOrderInfo findInfoByTrackingNo(String trackingNo);
    PageInfo<PplaSalesOrderInfo> page(Pageable page);

}
