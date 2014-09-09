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

import com.ppla.app.services.process.PrintingProcessService;
import com.ppla.core.dto.process.PrintingProcessInfo;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/printing")
public class PrintingProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(MixingProcessResource.class);

    @Autowired
    private PrintingProcessService service;

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<PrintingProcessInfo> findById(Principal principal, @PathVariable Long id) {
        LOG.debug("Finding printing process. id={}", id);
        return new ResponseEntity<>(service.findOneInfo(id), OK);
    }

    @RequestMapping(value = "/rollTag/{tag}", method = GET)
    public ResponseEntity<PrintingProcessInfo> findByRollTag(@PathVariable String tag) {
        LOG.debug("Finding printing process by roll tag. tag={}", tag);
        return new ResponseEntity<>(service.findInfoByRollTag(tag), OK);
    }

    @RequestMapping(value = "/start", method = POST)
    public ResponseEntity<PrintingProcessInfo> start(Principal principal,
            @RequestBody PrintingProcessInfo process) {
        LOG.debug("Starting printing process. process={}", process);
        return new ResponseEntity<>(service.startInfo(process), OK);
    }

    @RequestMapping(value = "/end", method = POST)
    public ResponseEntity<PrintingProcessInfo> end(Principal principal,
            @RequestBody PrintingProcessInfo process) {
        LOG.debug("Ending printing process. process={}", process);
        return new ResponseEntity<>(service.endInfo(process), OK);
    }

}
