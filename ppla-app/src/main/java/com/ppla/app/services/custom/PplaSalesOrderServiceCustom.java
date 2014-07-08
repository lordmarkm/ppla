package com.ppla.app.services.custom;

import com.ppla.core.dto.PplaSalesOrderInfo;

/**
 * @author Mark
 */
public interface PplaSalesOrderServiceCustom {

    PplaSalesOrderInfo assemble(String trackingNo);

}
