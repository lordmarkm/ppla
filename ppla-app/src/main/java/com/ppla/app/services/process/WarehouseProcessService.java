package com.ppla.app.services.process;

import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.process.custom.WarehouseProcessServiceCustom;

/**
 * @author mbmartinez
 */
public interface WarehouseProcessService extends BasePplaProcessService<WarehouseProcess>,
    WarehouseProcessServiceCustom {

}
