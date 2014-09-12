package com.ppla.web.resource.process;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.servicebase.custom.AbstractPplaProcessService;
import com.ppla.app.services.process.CuttingProcessService;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.app.services.process.MixingProcessService;
import com.ppla.app.services.process.PrintingProcessService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.ppla.core.dto.process.CuttingProcessInfo;
import com.ppla.core.dto.process.ExtrusionProcessInfo;
import com.ppla.core.dto.process.MixingProcessInfo;
import com.ppla.core.dto.process.PrintingProcessInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;

@RestController
@RequestMapping("/process")
public class ProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(ProcessResource.class);

    @Autowired
    private WarehouseProcessService warehouse;

    @Autowired
    private MixingProcessService mixing;

    @Autowired
    private ExtrusionProcessService extrusion;

    @Autowired
    private PrintingProcessService printing;

    @Autowired
    private CuttingProcessService cutting;

    @RequestMapping(method = GET)
    public ResponseEntity<List<BasePplaProcessInfo>> findByWorkOrderTrackingNo(
            @RequestParam String trackingNo) {

        LOG.debug("Retrieving all processes for work order. trackingNo={}", trackingNo);

        List<BasePplaProcessInfo> processes = Lists.newArrayList();

        //Warehouse
        List<WarehouseProcessInfo> warehouseProcesses = warehouse.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(warehouseProcesses);

        //Mixing
        List<MixingProcessInfo> mixingProcesses = mixing.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(mixingProcesses);

        //Extrusion
        List<ExtrusionProcessInfo> extrusionProcesses = extrusion.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(extrusionProcesses);

        //Printing
        List<PrintingProcessInfo> printingProcesses = printing.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(printingProcesses);

        //Cutting
        List<CuttingProcessInfo> cuttingProcesses = cutting.findByWorkOrder_TrackingNoInfo(trackingNo);
        processes.addAll(cuttingProcesses);

        AbstractPplaProcessService.sortByDate(processes);

        return new ResponseEntity<>(processes, OK);
    }

}
