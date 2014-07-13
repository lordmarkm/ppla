package com.ppla.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.core.dto.PplaWorkOrderInfo;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author Mark
 */
@RestController
@RequestMapping("/workOrder")
public class WorkOrderResource {

    @Autowired
    private PplaWorkOrderService service;

    @RequestMapping(value = "/sameproduct/{orderItemId}", method = GET)
    public ResponseEntity<List<PplaWorkOrderInfo>> findAttachable(@PathVariable Long orderItemId) {
        List<PplaWorkOrderInfo> sameProductList = service.findOpenWithSameProduct(orderItemId);
        return new ResponseEntity<>(dummy, OK);
    }

    @RequestMapping(value = "/new/{orderItemId}", method = POST)
    public ResponseEntity<PplaWorkOrderInfo> createNew(@PathVariable Long orderItemId,
            @RequestBody PplaWorkOrderInfo workOrder) {
        return new ResponseEntity<>(service.createNew(orderItemId, workOrder), OK);
    }

    @RequestMapping(value = "/attach/{orderItemId}/{trackingNo}", method = PUT)
    public ResponseEntity<PplaWorkOrderInfo> attach(@PathVariable Long orderItemId,
            @PathVariable String trackingNo) {
        return new ResponseEntity<>(service.attach(orderItemId, trackingNo), OK);
    }
}
