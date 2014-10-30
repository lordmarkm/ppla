package com.ppla.app.services.process.custom.impl;

import org.springframework.data.domain.PageRequest;

import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.app.services.process.custom.WarehouseProcessServiceCustom;
import com.ppla.core.dto.process.WarehouseProcessInfo;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author mbmartinez
 */
public class WarehouseProcessServiceCustomImpl extends AbstractPplaProcessService<WarehouseProcess, WarehouseProcessInfo, WarehouseProcessService> 
    implements WarehouseProcessServiceCustom {

    @Override
    public WarehouseProcessInfo endInfo(WarehouseProcessInfo processInfo) {
        throw new RuntimeException("End process operation not supported for warehouse processes.");
    }

    @Override
    public PageInfo<WarehouseProcessInfo> pageInfoByMachineId(Long machineId, PageRequest pageRequest) {
        throw new RuntimeException("Find by machine operation not supported for warehouse processes.");
    }

}
