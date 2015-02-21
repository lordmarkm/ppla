package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ppla.core.dto.machine.MachineInfo;

@Transactional
public interface BasePplaMachineServiceCustom<D extends MachineInfo> {

    List<D> findAllInfo();
    D findOneInfo(Long id);
    D saveInfo(D machineInfo);
    void softDelete(Long id);

}
