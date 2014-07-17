package com.ppla.app.services.process.custom.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.app.services.process.custom.WarehouseProcessServiceCustom;
import com.ppla.core.dto.process.WarehouseProcessInfo;

public class WarehouseProcessServiceCustomImpl extends AbstractPplaProcessService<WarehouseProcess, WarehouseProcessInfo> 
    implements WarehouseProcessServiceCustom {

    private static Logger LOG = LoggerFactory.getLogger(WarehouseProcessServiceCustomImpl.class);

    @Autowired
    private WarehouseProcessService service;

    public WarehouseProcessServiceCustomImpl() {
        super(WarehouseProcess.class, WarehouseProcessInfo.class);
    }

    @Override
    public BasePplaProcessService<WarehouseProcess> getRepo() {
        return service;
    }

    @Override
    public WarehouseProcessInfo save(String username, WarehouseProcessInfo process) {
        LOG.debug("About to save Warehouse Process. process={}", process);
        return super.save(username, process);
    }

}
