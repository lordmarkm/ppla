package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.custom.MaterialBalanceService;
import com.ppla.core.dto.material.MaterialBalanceStackInfo;
import com.ppla.core.reference.MaterialSource;

@RestController
@RequestMapping("/womaterials")
public class WorkorderMaterialResource {

    private static final Logger LOG = LoggerFactory.getLogger(WorkorderMaterialResource.class);

    @Autowired
    private MaterialBalanceService materialBalanceService;

    @RequestMapping(value = "/{trackingNos}/{source}", method = GET)
    public ResponseEntity<List<MaterialBalanceStackInfo>> getWorkOrderMaterialBalance(
            @PathVariable String trackingNos, @PathVariable MaterialSource source) {
        LOG.debug("Computing material balance for work order. trackingNos={}", trackingNos);
        return new ResponseEntity<>(materialBalanceService.computeMaterialBalance(trackingNos, source), OK);
    }

}
