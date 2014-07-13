package com.ppla.web.resource;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.PplaOrderItemService;
import com.ppla.core.dto.PplaOrderItemInfo;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

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
}
