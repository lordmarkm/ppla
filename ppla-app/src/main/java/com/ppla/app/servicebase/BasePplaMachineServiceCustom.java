package com.ppla.app.servicebase;

import java.util.List;

import com.ppla.core.dto.machine.MachineInfo;

public interface BasePplaMachineServiceCustom<D extends MachineInfo> {

    List<D> findAllInfo();
    D findOneInfo(Long id);
    D saveInfo(D machineInfo);

}
