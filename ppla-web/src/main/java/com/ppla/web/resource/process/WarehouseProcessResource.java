package com.ppla.web.resource.process;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.process.WarehouseProcessInfo;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(WarehouseProcessResource.class);

    @Autowired
    private WarehouseProcessService service;

    @RequestMapping(method = POST)
    public ResponseEntity<WarehouseProcessInfo> save(Principal principal,
            @RequestBody WarehouseProcessInfo process) {

        LOG.debug("Saving warehouse process. process={}", process);
        return new ResponseEntity<>(service.save(principal, process), OK);

    }

}
