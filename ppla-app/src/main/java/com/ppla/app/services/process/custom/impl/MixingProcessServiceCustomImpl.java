package com.ppla.app.services.process.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.MixingProcessService;
import com.ppla.app.services.process.custom.MixingProcessServiceCustom;
import com.ppla.core.dto.process.MixingProcessInfo;

public class MixingProcessServiceCustomImpl extends AbstractPplaProcessService<MixingProcess, MixingProcessInfo> 
    implements MixingProcessServiceCustom  {

    @Autowired
    private MixingProcessService service;

    public MixingProcessServiceCustomImpl() {
        super(MixingProcess.class, MixingProcessInfo.class);
    }

    @Override
    public BasePplaProcessService<MixingProcess> getRepo() {
        return service;
    }
}
