package com.ppla.web.resource.process;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.core.dto.process.ExtrusionProcessInfo;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/extrusion")
public class ExtrusionProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(MixingProcessResource.class);

    @Autowired
    private ExtrusionProcessService service;

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<ExtrusionProcessInfo> findById(Principal principal, @PathVariable Long id) {
        LOG.debug("Finding mixing process. id={}", id);
        return new ResponseEntity<>(service.findOneInfo(id), OK);
    }

    /**
     * Neither start nor end, merely Stage.
     */
    @RequestMapping(value = "/stage", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> stage(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        LOG.debug("Saving mixing process. process={}", process);
        return new ResponseEntity<>(service.saveInfo(process), OK);
    }

    @RequestMapping(value = "/start", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> start(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        LOG.debug("Starting mixing process. process={}", process);
        return new ResponseEntity<>(service.startInfo(process), OK);
    }

    @RequestMapping(value = "/end", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> end(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        LOG.debug("Ending mixing process. process={}", process);
        return new ResponseEntity<>(service.endInfo(process), OK);
    }

}
