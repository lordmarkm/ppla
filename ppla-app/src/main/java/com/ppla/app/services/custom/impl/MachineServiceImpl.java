package com.ppla.app.services.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppla.app.services.custom.MachineService;
import com.ppla.app.services.machine.ExtruderService;
import com.ppla.app.services.machine.MixerService;
import com.ppla.core.dto.machine.MachineInventoryInfo;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MixerService mixerService;

    @Autowired
    private ExtruderService extruderService;

    @Override
    public MachineInventoryInfo getMachines() {
        // TODO Auto-generated method stub
        return null;
    }

}
