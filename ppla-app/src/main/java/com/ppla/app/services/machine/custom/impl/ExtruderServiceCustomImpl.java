package com.ppla.app.services.machine.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ppla.app.models.machine.Extruder;
import com.ppla.app.models.process.ExtrusionProcess;
import com.ppla.app.models.process.QExtrusionProcess;
import com.ppla.app.servicebase.custom.AbstractPplaMachineService;
import com.ppla.app.services.machine.ExtruderService;
import com.ppla.app.services.machine.custom.ExtruderServiceCustom;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.core.dto.machine.ExtruderInfo;
import com.ppla.core.dto.process.ExtrusionProcessInfo;
import static com.ppla.app.models.process.QExtrusionProcess.extrusionProcess;

/**
 * @author mbmartinez
 */
public class ExtruderServiceCustomImpl extends AbstractPplaMachineService<Extruder, ExtruderInfo, ExtruderService>
    implements ExtruderServiceCustom {

    @Autowired
    private ExtrusionProcessService extrusionProcessService;

    @Override
    public ExtruderInfo findOneInfo(Long id) {
        ExtruderInfo extruder = super.findOneInfo(id);
        setStagedProcesses(extruder);

        return extruder;
    }

    @Override
    public List<ExtruderInfo> findAllInfo() {
        List<ExtruderInfo> extruders = super.findAllInfo();
        for (ExtruderInfo extruder : extruders) {
            setStagedProcesses(extruder);
        }

        return extruders;
    }

    private void setStagedProcesses(ExtruderInfo extruder) {
        //Find staged processes (null start date) assigned to this machine
        List<ExtrusionProcess> staged = (List<ExtrusionProcess>) extrusionProcessService.findAll(
            extrusionProcess.machine.code.eq(extruder.getCode())
                .and(extrusionProcess.dateStarted.isNull())
        );

        List<ExtrusionProcessInfo> stagedInfo = Lists.newArrayList();
        for (ExtrusionProcess e : staged) {
             stagedInfo.add(mapper.map(e, ExtrusionProcessInfo.class));
        }
        extruder.setStaged(stagedInfo);
    }

}
