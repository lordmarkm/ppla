package com.ppla.web.resource.process;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/process")
public class ProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(ProcessResource.class);

    @Autowired
    private WarehouseProcessService warehouse;

    @RequestMapping(method = GET)
    public ResponseEntity<List<BasePplaProcessInfo>> findByWorkOrderTrackingNo(
            @RequestParam String trackingNo) {

        LOG.debug("Retrieving all processes for work order. trackingNo={}", trackingNo);

        List<BasePplaProcessInfo> processes = Lists.newArrayList();
        List<WarehouseProcessInfo> warehouseProcesses = warehouse.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(warehouseProcesses);

        AbstractPplaProcessService.sortByDate(processes);
        return new ResponseEntity<>(processes, OK);
    }

}
