package com.ppla.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.core.dto.PplaWorkOrderInfo;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author Mark
 */
@RestController
@RequestMapping("/workorder")
public class WorkOrderResource {

    @Autowired
    private PplaWorkOrderService service;

    @RequestMapping(method = POST)
    public ResponseEntity<PplaWorkOrderInfo> save(PplaWorkOrderInfo workOrder) {
        return new ResponseEntity<>(service.save(workOrder), OK);
    }

}
