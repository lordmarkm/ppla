package com.ppla.web.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppla.app.services.ProcessMaterialService;
import com.ppla.app.services.RawMaterialService;
import com.ppla.app.services.custom.MaterialBalanceService;
import com.ppla.core.dto.material.BaseMaterialInfo;
import com.ppla.core.dto.material.MaterialBalanceStackInfo;
import com.ppla.core.dto.material.MaterialInventoryInfo;
import com.ppla.core.dto.material.ProcessMaterialInfo;
import com.ppla.core.dto.material.RawMaterialInfo;
import com.ppla.core.reference.MaterialSource;

@RestController
@RequestMapping("/material")
public class MaterialResource {

    private static final Logger LOG = LoggerFactory.getLogger(MaterialResource.class);

    @Autowired
    private RawMaterialService rawMaterials;

    @Autowired
    private ProcessMaterialService procMaterials;

    @Autowired
    private MaterialBalanceService materialBalanceService;

    @RequestMapping(method = GET)
    public ResponseEntity<MaterialInventoryInfo> findAll(Principal principal) {
        LOG.debug("Material inventory requested. user={}", principal);

        List<RawMaterialInfo> raws = rawMaterials.findAllNonDeleted();
        List<ProcessMaterialInfo> procs = procMaterials.findAllNonDeleted();

        MaterialInventoryInfo inventory = new MaterialInventoryInfo();
        inventory.getRawMaterials().addAll(raws);
        inventory.getProcMaterials().addAll(procs);

        return new ResponseEntity<>(inventory, OK);
    }

    @RequestMapping(value = "/process/{source}")
    public ResponseEntity<List<ProcessMaterialInfo>> findBySource(@PathVariable String source) {
        LOG.debug("Finding process materials by source. source={}", source);
        return new ResponseEntity<>(procMaterials.findBySourceInfo(source), OK);
    }

    @RequestMapping(value = "/raw", method = POST)
    public ResponseEntity<RawMaterialInfo> save(@RequestBody RawMaterialInfo newMaterial) {
        LOG.debug("Raw Material save request. material={}", newMaterial);
        return new ResponseEntity<>(rawMaterials.save(newMaterial), OK);
    }

    @RequestMapping(value = "/process", method = POST)
    public ResponseEntity<ProcessMaterialInfo> save(@RequestBody ProcessMaterialInfo newMaterial) {
        LOG.debug("Process Material save request. material={}", newMaterial);
        return new ResponseEntity<>(procMaterials.save(newMaterial), OK);
    }

    //TODO move to WO Material res
    @RequestMapping(value = "/{trackingNos}", method = GET)
    public ResponseEntity<List<MaterialBalanceStackInfo>> getWorkOrderMaterialBalance(@PathVariable String trackingNos) {
        LOG.debug("Computing material balance for work order. trackingNos={}", trackingNos);
        return new ResponseEntity<>(materialBalanceService.computeMaterialBalance(trackingNos), OK);
    }

}
