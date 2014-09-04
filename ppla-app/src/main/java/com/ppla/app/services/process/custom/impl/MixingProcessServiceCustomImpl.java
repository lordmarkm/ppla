package com.ppla.app.services.process.custom.impl;

import com.ppla.app.models.machine.Mixer;
import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.servicebase.custom.AbstractPplaMachineProcessService;
import com.ppla.app.services.machine.MixerService;
import com.ppla.app.services.process.MixingProcessService;
import com.ppla.app.services.process.custom.MixingProcessServiceCustom;
import com.ppla.core.dto.PplaWorkOrderInfo;
import com.ppla.core.dto.process.MixingProcessInfo;

/**
 * @author mbmartinez
 */
public class MixingProcessServiceCustomImpl extends AbstractPplaMachineProcessService<
    MixingProcess, 
    MixingProcessInfo, 
    MixingProcessService,
    Mixer,
    MixerService>

    implements MixingProcessServiceCustom  {

    /**
     * Custom handling for Mixing Process, because one mixing process
     * can have multiple work orders attached to it, sadly.
     * 
     * Set the first work order in the work orders list as the primary work order
     * for this mixing process before saving.
     */
    @Override
    public MixingProcessInfo startInfo(MixingProcessInfo processInfo) {

        PplaWorkOrderInfo firstWorkorder = processInfo.getWorkOrders().get(0);
        processInfo.setWorkOrder(firstWorkorder);

        return super.startMachineProcessInfo(processInfo);
    }

    @Override
    public MixingProcessInfo endInfo(MixingProcessInfo processInfo) {

        PplaWorkOrderInfo firstWorkorder = processInfo.getWorkOrders().get(0);
        processInfo.setWorkOrder(firstWorkorder);

        return super.endMachineProcessInfo(processInfo);
    }
}
