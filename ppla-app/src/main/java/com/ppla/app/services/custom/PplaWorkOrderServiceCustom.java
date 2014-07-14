package com.ppla.app.services.custom;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.ppla.core.dto.PplaWorkOrderInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

/**
 * @author Mark
 */
public interface PplaWorkOrderServiceCustom {

    PplaWorkOrderInfo save(PplaWorkOrderInfo workOrder);
    PplaWorkOrderInfo createNew(Long orderItemId, PplaWorkOrderInfo workOrder);
    PplaWorkOrderInfo attach(Long orderItemId, String trackingNo);
    PplaWorkOrderInfo findByTrackingNoInfo(String trackingNo);
    PplaWorkOrderInfo close(String trackingNo);
    List<PplaWorkOrderInfo> findOpenWithSameProductInfo(Long orderItemId);
    PageInfo<PplaWorkOrderInfo> page(PageRequest pageRequest);

}
