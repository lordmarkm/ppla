package com.ppla.app.services.test;

import static org.junit.Assert.*;

import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppla.app.config.SupportConfig;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.machine.Mixer;
import com.ppla.app.models.process.MixingProcess;
import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.core.dto.machine.MachineInfo;
import com.ppla.core.dto.process.MixingProcessInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    SupportConfig.class
})
public class MapperTest {

    @Autowired
    private Mapper mapper;

    @Test
    public void testInheritance() {
        String tNum = "tNum";

        PplaWorkOrder wo = new PplaWorkOrder();
        wo.setTrackingNo(tNum);
        WarehouseProcess process = new WarehouseProcess();
        process.setWorkOrder(wo);
        process.setDateCompleted(DateTime.now());

        WarehouseProcessInfo dto = mapper.map(process, WarehouseProcessInfo.class);
        assertEquals(tNum, dto.getWorkOrder().getTrackingNo());
        assertNotNull(dto.getDateCompleted());
    }

    @Test
    public void testProcessMap() {
        MixingProcess process = new MixingProcess();
        Mixer mixer = new Mixer();
        mixer.setCurrentProcess(process);

        MachineInfo info = mapper.map(mixer, MachineInfo.class);
        assertNotNull(info);
    }
}
