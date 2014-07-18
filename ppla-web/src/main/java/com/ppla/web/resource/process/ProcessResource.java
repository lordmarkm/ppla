package com.ppla.web.resource.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;

@RestController
@RequestMapping("/process")
public class ProcessResource {

    @Autowired
    private WarehouseProcessService warehouse;

    @RequestMapping("/{trackingNo}")
    public List<BasePplaProcessInfo> findByWorkOrderTrackingNo(String trackingNo) {
        List<BasePplaProcessInfo> processes = Lists.newArrayList();
        List<WarehouseProcessInfo> warehouseProcesses = warehouse.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(warehouseProcesses);
        return processes;
    }

}
