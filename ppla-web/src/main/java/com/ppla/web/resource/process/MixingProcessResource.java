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

import com.ppla.app.services.process.MixingProcessService;
import com.ppla.core.dto.process.MixingProcessInfo;

/**
 * @author Mark
 */
@RestController
@RequestMapping("/mixing")
public class MixingProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(MixingProcessResource.class);

    @Autowired
    private MixingProcessService service;

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<MixingProcessInfo> findById(Principal principal, @PathVariable Long id) {

        LOG.debug("Finding mixing process. id={}", id);
        return new ResponseEntity<>(service.findOneInfo(id), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<MixingProcessInfo> save(Principal principal,
            @RequestBody MixingProcessInfo process) {

        LOG.debug("Saving mixing process. process={}", process);
        return new ResponseEntity<>(service.save(principal.getName(), process), OK);
    }
}
