package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(method = GET)
    public ResponseEntity<MachineInventoryInfo> getMachineInventory(Principal principal) {
        LOG.debug("Inventory request. user={}", principal);
        MachineInventoryInfo inventory = new MachineInventoryInfo();
        inventory.setMixers(mixerService.findAllInfo());
        inventory.setExtruders(extruderService.findAllInfo());
        return new ResponseEntity<>(inventory, OK);
    }

    @RequestMapping(value = "/EXTRUSION", method = GET)
    public ResponseEntity<List<ExtruderInfo>> getExtruders(@PathVariable ProcessType type) {
        LOG.debug("Machines request. type={}");
        return new ResponseEntity<>(extruderService.findAllInfo(), OK);
    }

    @RequestMapping(value = "/EXTRUSION", method = POST)
    public ResponseEntity<ExtruderInfo> saveMachine(Principal principal, @RequestBody ExtruderInfo machineInfo) {
        LOG.debug("Machine save request. user={}", principal);
        return new ResponseEntity<>(extruderService.saveInfo(machineInfo), OK);
    }

    @RequestMapping(value = "/{type}", method = GET)
    public ResponseEntity<List<MachineInfo>> getMachinesOfType(@PathVariable ProcessType type) {
        LOG.debug("Machines request. type={}");
        return new ResponseEntity<>(getService(type).findAllInfo(), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<MachineInfo> saveMachine(Principal principal, @RequestBody MachineInfo machineInfo) {
        LOG.debug("Machine save request. user={}", principal);
        return new ResponseEntity<>(getService(machineInfo.getType()).saveInfo(machineInfo), OK);
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
