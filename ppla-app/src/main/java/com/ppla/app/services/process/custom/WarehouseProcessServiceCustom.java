package com.ppla.app.services.process.custom;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ppla.core.dto.process.WarehouseProcessInfo;

/**
 * @author mbmartinez
 */
@Transactional
public interface WarehouseProcessServiceCustom {

    WarehouseProcessInfo save(String username, WarehouseProcessInfo process);
    List<WarehouseProcessInfo> findByWorkOrder_TrackingNoInfo(String trackingNo);

}
