package com.ppla.app.services.machine.custom.impl;

import java.util.List;

import com.ppla.app.models.machine.Extruder;
import com.ppla.app.servicebase.custom.AbstractPplaMachineService;
import com.ppla.app.services.machine.ExtruderService;
import com.ppla.app.services.machine.custom.ExtruderServiceCustom;
import com.ppla.core.dto.machine.ExtruderInfo;

/**
 * @author mbmartinez
 */
public class ExtruderServiceCustomImpl extends AbstractPplaMachineService<Extruder, ExtruderInfo, ExtruderService>
    implements ExtruderServiceCustom {

    @Override
    public List<ExtruderInfo> findAllInfo() {
        List<ExtruderInfo> extruders = super.findAllInfo();
        return extruders;
        return toDto(repo.findAll());
    }

    @Override
    public ExtruderInfo findOneInfo(Long id) {
        return toDto(repo.findOne(id));
    }

}
