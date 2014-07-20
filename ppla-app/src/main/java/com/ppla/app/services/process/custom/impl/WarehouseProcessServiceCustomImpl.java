package com.ppla.app.services.process.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.app.services.process.custom.WarehouseProcessServiceCustom;
import com.ppla.core.dto.process.WarehouseProcessInfo;

public class WarehouseProcessServiceCustomImpl extends AbstractPplaProcessService<WarehouseProcess, WarehouseProcessInfo> 
    implements WarehouseProcessServiceCustom {

    @Autowired
    private WarehouseProcessService service;

    public WarehouseProcessServiceCustomImpl() {
        super(WarehouseProcess.class, WarehouseProcessInfo.class);
    }

    @Override
    public BasePplaProcessService<WarehouseProcess> getRepo() {
        return service;
    }

}
