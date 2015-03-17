package com.ppla.web.resource.process;

import static com.tyrael.commons.reports.util.JasperResourceHelper.exportToPdfResponseEntity;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
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

import com.google.common.collect.Maps;
import com.ppla.app.services.ProcessMaterialStackService;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.app.services.reports.RollTagReportService;
import com.ppla.core.dto.process.ExtrusionProcessInfo;
import com.ppla.core.dto.report.RollTagReportInfo;
import com.tyrael.commons.dto.PageInfo;

/**
 * @author mbmartinez
 */
@RestController
@RequestMapping("/extrusion")
public class ExtrusionProcessResource {

    private static Logger LOG = LoggerFactory.getLogger(MixingProcessResource.class);

    @Autowired
    private ExtrusionProcessService service;

    @Autowired
    private ProcessMaterialStackService stackService;

    @Autowired
    private RollTagReportService rollTagReportService;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<ExtrusionProcessInfo>> findByMachine(Principal principal,
            @RequestParam int page,
            @RequestParam int count,
            @RequestParam Long machineId) {

        LOG.debug("User query. Principal={}, page={}, count={}, machineId={}", principal, page, count, machineId);

        PageRequest pageRequest = new PageRequest(page - 1, count);

        return new ResponseEntity<>(service.pageInfoByMachineId(machineId, pageRequest), OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<ExtrusionProcessInfo> findById(Principal principal, @PathVariable Long id) {
        LOG.debug("Finding extrusion process. id={}", id);
        return new ResponseEntity<>(service.findOneInfo(id), OK);
    }

    /**
     * Neither start nor end, merely Stage.
     */
    @RequestMapping(value = "/stage", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> stage(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        process.setDateStaged(DateTime.now());
        LOG.debug("Staging extrusion process. process={}", process);
        return new ResponseEntity<>(service.saveInfo(process), OK);
    }

    @RequestMapping(value = "/start", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> start(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        LOG.debug("Starting extrusion process. process={}", process);
        return new ResponseEntity<>(service.startInfo(process), OK);
    }

    @RequestMapping(value = "/end", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> end(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        LOG.debug("Ending extrusion process. process={}", process);
        return new ResponseEntity<>(service.endInfo(process), OK);
    }

    @RequestMapping(value = "/unload", method = POST)
    public ResponseEntity<ExtrusionProcessInfo> unload(Principal principal,
            @RequestBody ExtrusionProcessInfo process) {
        LOG.debug("Ending extrusion process. process={}", process);
        return new ResponseEntity<>(service.unloadInfo(process), OK);
    }

    @RequestMapping(value = "/printtag/{extrusionProcessId}/{tags}", method = GET)
    public ResponseEntity<byte[]> printTag(@PathVariable Long extrusionProcessId, @PathVariable String tags) {
        LOG.debug("About to print tag slip. tags={}", tags);

        String template = "tag";
        String filename = tags;

        List<RollTagReportInfo> rolls = rollTagReportService.printTags(extrusionProcessId, tags);
        LOG.debug("Found rolls. size={}", rolls.size());
        Map<String, Object> params = Maps.newHashMap();
        params.put("rolls", rolls);

        ResponseEntity<byte[]> pdf = exportToPdfResponseEntity(template, filename,
                params, Collections.singletonList(rolls.get(0)));

        return pdf;
    }
}
