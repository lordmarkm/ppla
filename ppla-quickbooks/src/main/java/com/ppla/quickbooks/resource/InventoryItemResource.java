package com.ppla.quickbooks.resource;

import static org.springframework.http.HttpStatus.OK;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.quickbooks.dto.InventoryItemInfo;
import com.ppla.quickbooks.service.InventoryItemService;
import com.tyrael.commons.mapper.dto.PageInfo;

@RestController
@RequestMapping("/inventoryitem")
public class InventoryItemResource {

    private static Logger LOG = LoggerFactory.getLogger(InventoryItemResource.class);

    @Autowired
    private InventoryItemService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PageInfo<InventoryItemInfo>> query(Principal principal,
            @RequestParam int page,
            @RequestParam int count) {
        LOG.debug("InventoryItemInfo browse query. Principal={}, page={}, count={}", principal, page, count);
        PageRequest pageRequest = new PageRequest(page - 1, count);
        return new ResponseEntity<>(service.pageInfo(pageRequest), OK);

    }
}
