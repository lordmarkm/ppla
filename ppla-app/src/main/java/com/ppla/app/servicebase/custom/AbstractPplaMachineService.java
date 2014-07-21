package com.ppla.app.servicebase.custom;

import com.ppla.app.models.machine.Machine;
import com.ppla.app.servicebase.BasePplaMachineService;
import com.ppla.core.dto.machine.MachineInfo;

public abstract class AbstractPplaMachineService<E extends Machine, D extends MachineInfo> {

    protected abstract BasePplaMachineService<E> getRepo();

    public MachineInfo findOneInfo(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public MachineInfo save(MachineInfo machineInfo) {
        // TODO Auto-generated method stub
        return null;
    }

}
