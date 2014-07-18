package com.ppla.app.services.process;

import org.springframework.transaction.annotation.Transactional;

import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.process.custom.WarehouseProcessServiceCustom;

/**
 * @author mbmartinez
 */
@Transactional
public interface WarehouseProcessService extends BasePplaProcessService<WarehouseProcess>,
    WarehouseProcessServiceCustom {

}
