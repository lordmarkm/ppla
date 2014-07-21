package com.ppla.app.servicebase;

import com.ppla.core.dto.machine.MachineInfo;

public interface BasePplaMachineServiceCustom<D extends MachineInfo> {

    D findOneInfo(Long id);
    D save(D machineInfo);

}
