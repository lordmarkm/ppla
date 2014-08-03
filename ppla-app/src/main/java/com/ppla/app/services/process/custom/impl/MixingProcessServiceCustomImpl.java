package com.ppla.app.services.process.custom.impl;

import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.MixingProcessService;
import com.ppla.app.services.process.custom.MixingProcessServiceCustom;
import com.ppla.core.dto.process.MixingProcessInfo;

/**
 * @author mbmartinez
 */
public class MixingProcessServiceCustomImpl extends AbstractPplaProcessService<MixingProcess, MixingProcessInfo, MixingProcessService> 
    implements MixingProcessServiceCustom  {

    public MixingProcessServiceCustomImpl() {
        super(MixingProcess.class, MixingProcessInfo.class);
    }

}
