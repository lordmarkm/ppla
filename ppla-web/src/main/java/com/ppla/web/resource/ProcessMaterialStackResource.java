package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.services.ProcessMaterialStackService;
import com.ppla.core.dto.material.ProcessMaterialStackInfo;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/stack")
public class ProcessMaterialStackResource {

    private static Logger LOG = LoggerFactory.getLogger(ProcessMaterialStackResource.class);

    @Autowired
    private ProcessMaterialStackService pmsService; //lol

    @Autowired
    private Mapper mapper;

    @RequestMapping(value = "/{tag}", method = GET)
    public ResponseEntity<ProcessMaterialStackInfo> findByTag(@PathVariable String tag) {
        LOG.debug("Finding process material stack. tag={}", tag);

        ProcessMaterialStack pms = pmsService.findByTag(tag);
        ProcessMaterialStackInfo pmsInfo = null;
        if (null != pms) {
            pmsInfo = mapper.map(pms, ProcessMaterialStackInfo.class);
        }

        return new ResponseEntity<>(pmsInfo, OK);
    }
}
