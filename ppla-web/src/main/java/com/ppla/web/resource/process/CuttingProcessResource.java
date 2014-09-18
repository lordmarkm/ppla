package com.ppla.web.resource.process;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;

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

import com.ppla.app.services.process.CuttingProcessService;
import com.ppla.core.dto.process.CuttingProcessInfo;
import com.ppla.core.dto.process.PrintingProcessInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/cutting")
public class CuttingProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(MixingProcessResource.class);

    @Autowired
    private CuttingProcessService service;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<CuttingProcessInfo>> findByMachine(Principal principal,
            @RequestParam int page,
            @RequestParam int count,
            @RequestParam Long machineId) {

        LOG.debug("User query. Principal={}, page={}, count={}, machineId={}", principal, page, count, machineId);

        PageRequest pageRequest = new PageRequest(page - 1, count);

        return new ResponseEntity<>(service.pageInfoByMachineId(machineId, pageRequest), OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<CuttingProcessInfo> findById(Principal principal, @PathVariable Long id) {
        LOG.debug("Finding cutting process. id={}", id);
        return new ResponseEntity<>(service.findOneInfo(id), OK);
    }

    @RequestMapping(value = "/rollTag/{tag}", method = GET)
    public ResponseEntity<CuttingProcessInfo> findByRollTag(@PathVariable String tag) {
        LOG.debug("Finding cutting process by roll tag. tag={}", tag);
        return new ResponseEntity<>(service.findInfoByRollTag(tag), OK);
    }

    @RequestMapping(value = "/start", method = POST)
    public ResponseEntity<CuttingProcessInfo> start(Principal principal,
            @RequestBody CuttingProcessInfo process) {
        LOG.debug("Starting cutting process. process={}", process);
        return new ResponseEntity<>(service.startInfo(process), OK);
    }

    @RequestMapping(value = "/end", method = POST)
    public ResponseEntity<CuttingProcessInfo> end(Principal principal,
            @RequestBody CuttingProcessInfo process) {
        LOG.debug("Ending cutting process. process={}", process);
        return new ResponseEntity<>(service.endInfo(process), OK);
    }

}
