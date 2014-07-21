package com.ppla.web.resource;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.core.dto.machine.MachineInventoryInfo;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/machine")
public class MachineResource {

    @Autowired
    private MachineService service;

    @RequestMapping(method = GET)
    public ResponseEntity<MachineInventoryInfo> getMachines(Principal principal) {
        return new ResponseEntity<>(service.getMachines(), OK);
    }

}
