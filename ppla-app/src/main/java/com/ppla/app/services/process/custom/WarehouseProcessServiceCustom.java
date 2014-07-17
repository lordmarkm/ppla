package com.ppla.app.services.process.custom;

import com.ppla.core.dto.process.WarehouseProcessInfo;

/**
 * @author mbmartinez
 */
public interface WarehouseProcessServiceCustom {

    WarehouseProcessInfo save(String username, WarehouseProcessInfo process);

}
