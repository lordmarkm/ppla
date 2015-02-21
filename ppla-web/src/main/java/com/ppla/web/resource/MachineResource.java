package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.servicebase.BasePplaMachineServiceCustom;
import com.ppla.app.services.machine.CutterService;
import com.ppla.app.services.machine.ExtruderService;
import com.ppla.app.services.machine.MixerService;
import com.ppla.app.services.machine.PrinterService;
import com.ppla.core.dto.machine.ExtruderInfo;
import com.ppla.core.dto.machine.MachineInfo;
import com.ppla.core.dto.machine.MachineInventoryInfo;
import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/machine")
public class MachineResource {

    private static Logger LOG = LoggerFactory.getLogger(MachineResource.class);

    @Autowired
    private MixerService mixerService;

    @Autowired
    private ExtruderService extruderService;

    @Autowired
    private PrinterService printerService;

    @Autowired
    private CutterService cutterService;

    @RequestMapping(value = "/{type}/{id}", method = GET)
    public ResponseEntity<MachineInfo> findOne(@PathVariable ProcessType type, @PathVariable Long id) {
        return new ResponseEntity<>(getService(type).findOneInfo(id), OK);
    }
    @RequestMapping(value = "/EXTRUSION/{id}", method = GET)
    public ResponseEntity<ExtruderInfo> findOneExtruder(@PathVariable Long id) {
        return new ResponseEntity<>(extruderService.findOneInfo(id), OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<MachineInventoryInfo> getMachineInventory(Principal principal) {
        LOG.debug("Inventory request. user={}", principal);
        MachineInventoryInfo inventory = new MachineInventoryInfo();
        inventory.setMixers(mixerService.findAllInfo());
        inventory.setExtruders(extruderService.findAllInfo());
        inventory.setPrinters(printerService.findAllInfo());
        inventory.setCutters(cutterService.findAllInfo());
        return new ResponseEntity<>(inventory, OK);
    }

    @RequestMapping(value = "/EXTRUSION", method = GET)
    public ResponseEntity<List<ExtruderInfo>> getExtruders() {
        LOG.debug("Extruders request. type={}");
        return new ResponseEntity<>(extruderService.findAllInfo(), OK);
    }

    @RequestMapping(value = "/EXTRUSION", method = POST)
    public ResponseEntity<ExtruderInfo> saveMachine(Principal principal, @RequestBody ExtruderInfo machineInfo) {
        LOG.debug("Extruder save request. user={}", principal);
        return new ResponseEntity<>(extruderService.saveInfo(machineInfo), OK);
    }

    @RequestMapping(value = "/{type}", method = GET)
    public ResponseEntity<List<MachineInfo>> getMachinesOfType(@PathVariable ProcessType type) {
        LOG.debug("Machines request. type={}");

        return new ResponseEntity<>(getService(type).findAllInfo(), OK);
    }

    @RequestMapping(value = "/{type}", method = POST)
    public ResponseEntity<MachineInfo> saveMachine(Principal principal, @PathVariable ProcessType type,
            @RequestBody MachineInfo machineInfo) {
        LOG.debug("Machine save request. user={}", principal);
        return new ResponseEntity<>(getService(type).saveInfo(machineInfo), OK);
    }

    @RequestMapping(value = "/{type}/{id}", method = DELETE)
    public ResponseEntity<String> deleteMachine(@PathVariable ProcessType type, @PathVariable Long id) {
        LOG.debug("Trying to delete machine with id={}", id);
        switch(type) {
        case EXTRUSION:
            extruderService.softDelete(id);
            break;
        default:
            getService(type).softDelete(id);
        }
        return new ResponseEntity<>("Ok", OK);
    }

    private BasePplaMachineServiceCustom<MachineInfo> getService(ProcessType type) {
        switch (type) {
        case MIXING: return mixerService;
        case PRINTING: return printerService;
        case CUTTING: return cutterService;
        default:
            throw new IllegalArgumentException("Unknown machine type: " + type);
        }
    }
}
