package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.core.dto.PplaWorkOrderInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

/**
 * @author Mark
 */
@RestController
@RequestMapping("/workOrder")
public class WorkOrderResource {

    private static Logger LOG = LoggerFactory.getLogger(WorkOrderResource.class);

    @Autowired
    private PplaWorkOrderService service;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<PplaWorkOrderInfo>> findAll(Principal principal,
            @RequestParam int page,
            @RequestParam int count) {

        LOG.debug("Work Order browse query. Principal={}, page={}, count={}", principal, page, count);

        PageRequest pageRequest = new PageRequest(page - 1, count);
        return new ResponseEntity<>(service.page(pageRequest), OK);
    }

    @RequestMapping(value = "/{trackingNo}", method = GET)
    public ResponseEntity<PplaWorkOrderInfo> findOne(Principal principal, @PathVariable String trackingNo) {
        LOG.debug("Work order request. user={}, trackingNo={}", principal, trackingNo);
        return new ResponseEntity<>(service.findByTrackingNoInfo(trackingNo), OK);
    }

    @RequestMapping(value = "/sameproduct/{orderItemId}", method = GET)
    public ResponseEntity<List<PplaWorkOrderInfo>> findAttachable(@PathVariable Long orderItemId) {
        List<PplaWorkOrderInfo> sameProductList = service.findOpenWithSameProductInfo(orderItemId);
        return new ResponseEntity<>(sameProductList, OK);
    }

    @RequestMapping(value = "/new/{orderItemId}", method = POST)
    public ResponseEntity<PplaWorkOrderInfo> createNew(@PathVariable Long orderItemId,
            @RequestBody PplaWorkOrderInfo workOrder) {
        return new ResponseEntity<>(service.createNew(orderItemId, workOrder), OK);
    }

    @RequestMapping(value = "/attach/{orderItemId}/{trackingNo}", method = POST)
    public ResponseEntity<PplaWorkOrderInfo> attach(@PathVariable Long orderItemId,
            @PathVariable String trackingNo) {
        return new ResponseEntity<>(service.attach(orderItemId, trackingNo), OK);
    }

    @RequestMapping(value = "/close/{trackingNo}", method = POST)
    public ResponseEntity<PplaWorkOrderInfo> close(Principal principal, @PathVariable String trackingNo) {
        LOG.debug("Close request. user={}, tracking no={}", principal, trackingNo);
        return new ResponseEntity<>(service.close(trackingNo), OK);
    }
}
