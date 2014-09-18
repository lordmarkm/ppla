package com.ppla.web.resource.process;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaUser;
import com.ppla.app.services.process.MixingProcessService;
import com.ppla.core.dto.PplaUserInfo;
import com.ppla.core.dto.process.MixingProcessInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

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

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<MixingProcessInfo>> findByMachine(Principal principal,
            @RequestParam int page,
            @RequestParam int count,
            @RequestParam Long machineId) {

        LOG.debug("User query. Principal={}, page={}, count={}, machineId={}", principal, page, count, machineId);

        PageRequest pageRequest = new PageRequest(page - 1, count);

        return new ResponseEntity<>(service.pageInfoByMachineId(machineId, pageRequest), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<MixingProcessInfo> save(Principal principal,
            @RequestBody MixingProcessInfo process) {
        LOG.debug("Saving mixing process. process={}", process);
        return new ResponseEntity<>(service.startInfo(process), OK);
    }

    @RequestMapping(value = "/end", method = POST)
    public ResponseEntity<MixingProcessInfo> end(Principal principal,
            @RequestBody MixingProcessInfo process) {
        LOG.debug("Saving mixing process. process={}", process);
        return new ResponseEntity<>(service.endInfo(process), OK);
    }
}
