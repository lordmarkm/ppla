package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.PplaOrderItemService;
import com.ppla.core.dto.PplaOrderItemInfo;

@RestController
@RequestMapping("/orderItem")
public class OrderItemResource {

    private static Logger LOG = LoggerFactory.getLogger(OrderItemResource.class);

    @Autowired
    private PplaOrderItemService orderItemService;

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<PplaOrderItemInfo> findOne(Principal principal, @PathVariable Long id) {
        LOG.debug("Order item request. user={}, id={}", principal, id);
        return new ResponseEntity<>(orderItemService.findOneInfo(id), OK);
    }

    @RequestMapping(value = "/attached")
    public ResponseEntity<List<PplaOrderItemInfo>> findAttached(@RequestParam String workOrderTrackingNo) {
        LOG.debug("Attached order item request. Tracking no={}", workOrderTrackingNo);
        return new ResponseEntity<>(orderItemService.findAttachedInfo(workOrderTrackingNo), OK);
    }
}
