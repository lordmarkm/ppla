package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.core.dto.PplaWorkOrderInfo;

/**
 * @author Mark
 */
public interface PplaWorkOrderServiceCustom {

    List<PplaWorkOrderInfo> assembleBySalesOrder(PplaSalesOrder salesOrder);
    PplaWorkOrderInfo save(PplaWorkOrderInfo workOrder);

}
