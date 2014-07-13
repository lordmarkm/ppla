package com.ppla.app.services.custom;

import com.ppla.core.dto.PplaWorkOrderInfo;

/**
 * @author Mark
 */
public interface PplaWorkOrderServiceCustom {

    PplaWorkOrderInfo save(PplaWorkOrderInfo workOrder);
    PplaWorkOrderInfo createNew(Long orderItemId, PplaWorkOrderInfo workOrder);
    PplaWorkOrderInfo attach(Long orderItemId, String trackingNo);

}
