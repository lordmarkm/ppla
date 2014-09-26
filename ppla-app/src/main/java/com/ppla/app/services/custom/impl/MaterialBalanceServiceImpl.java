package com.ppla.app.services.custom.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ppla.app.services.custom.MaterialBalanceService;
import com.ppla.app.services.process.CuttingProcessService;
import com.ppla.app.services.process.ExtrusionProcessService;
import com.ppla.app.services.process.MixingProcessService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.material.MaterialBalanceStackInfo;
import com.ppla.core.dto.material.ProcessMaterialStackInfo;
import com.ppla.core.dto.material.RawMaterialStackInfo;
import com.ppla.core.dto.process.CuttingProcessInfo;
import com.ppla.core.dto.process.ExtrusionProcessInfo;
import com.ppla.core.dto.process.MixingProcessInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;
import com.ppla.core.reference.MaterialSource;
import static java.math.BigDecimal.ONE;

@Service
public class MaterialBalanceServiceImpl implements MaterialBalanceService {

    private static final Logger LOG = LoggerFactory.getLogger(MaterialBalanceServiceImpl.class);

    @Autowired
    private WarehouseProcessService warehouse;

    @Autowired
    private MixingProcessService mixing;

    @Autowired
    private ExtrusionProcessService extrusion;

    @Autowired
    private CuttingProcessService cutting;

    private static final Splitter tiago = Splitter.on(',')
        .trimResults()
        .omitEmptyStrings();

    @Override
    public List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNos) {
        Map<Long, MaterialBalanceStackInfo> materialBalance = Maps.newHashMap();
        processWarehouseProcesses(materialBalance, trackingNos);
        processMixingProcesses(materialBalance, trackingNos);
        processExtrusionProcesses(materialBalance, trackingNos);
        //Printing doesn't really use up materials, so it's not here
        processCuttingProcesses(materialBalance, trackingNos);

        return Lists.newArrayList(materialBalance.values());
    }

    private void processWarehouseProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNosString) {
        Iterable<String> trackingNos = tiago.split(trackingNosString);
        List<WarehouseProcessInfo> procs = Lists.newArrayList();
        for (String trackingNo : trackingNos) {
            procs.addAll(warehouse.findByWorkOrder_TrackingNoInfo(trackingNo));
        }
        for (WarehouseProcessInfo proc : procs) {
            for (RawMaterialStackInfo rawMatStack : proc.getMaterialStacks()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(rawMatStack.getMaterial().getId());
                if (null == currentBalance) {
                    LOG.debug("Creating new material balance stack for material={}, source=Warehouse (raw)", rawMatStack.getMaterial().getName());
                    currentBalance = new MaterialBalanceStackInfo();
                    currentBalance.setMaterial(rawMatStack.getMaterial());
                    currentBalance.setQuantityWithdrawn(rawMatStack.getQuantity());
                    currentBalance.setQuantityRemaining(rawMatStack.getQuantity());
                    currentBalance.setSource(MaterialSource.RAW);
                    materialBalance.put(rawMatStack.getMaterial().getId(), currentBalance);
                } else {
                    currentBalance.setQuantityWithdrawn(currentBalance.getQuantityWithdrawn().add(rawMatStack.getQuantity()));
                    currentBalance.setQuantityRemaining(currentBalance.getQuantityRemaining().add(rawMatStack.getQuantity()));
                }
            }
        }
    }

    private void processMixingProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNosString) {
        Iterable<String> trackingNos = tiago.split(trackingNosString);
        List<MixingProcessInfo> procs = Lists.newArrayList();
        for (String trackingNo : trackingNos) {
            procs.addAll(mixing.findByWorkOrder_TrackingNoInfo(trackingNo));
        }
        for (MixingProcessInfo proc : procs) {
            //Mixing process in
            for (RawMaterialStackInfo matStack : proc.getMaterialsIn()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(matStack.getMaterial().getId());
                Preconditions.checkNotNull(currentBalance,  "Material was consumed by Mixing process but never produced. mat=" + currentBalance.getMaterial().getName());
                currentBalance.setQuantityConsumed(currentBalance.getQuantityConsumed().add(matStack.getQuantity()));
                currentBalance.setQuantityRemaining(currentBalance.getQuantityRemaining().subtract(matStack.getQuantity()));
            }

            //Mixing process out
            for (ProcessMaterialStackInfo matStack : proc.getMaterialsOut()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(matStack.getMaterial().getId());
                if (null == currentBalance) {
                    LOG.debug("Creating new material balance stack for material={}, source=Mixing", matStack.getMaterial().getName());
                    currentBalance = new MaterialBalanceStackInfo();
                    currentBalance.setMaterial(matStack.getMaterial());
                    currentBalance.setQuantityWithdrawn(matStack.getQuantity());
                    currentBalance.setQuantityRemaining(matStack.getQuantity());
                    currentBalance.setSource(MaterialSource.MIXING);
                    materialBalance.put(matStack.getMaterial().getId(), currentBalance);
                } else {
                    currentBalance.setQuantityWithdrawn(currentBalance.getQuantityWithdrawn().add(matStack.getQuantity()));
                    currentBalance.setQuantityRemaining(currentBalance.getQuantityRemaining().add(matStack.getQuantity()));
                }
            }
        }
    }

    private void processExtrusionProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNosString) {
        Iterable<String> trackingNos = tiago.split(trackingNosString);
        List<ExtrusionProcessInfo> procs = Lists.newArrayList();
        for (String trackingNo : trackingNos) {
            procs.addAll(extrusion.findByWorkOrder_TrackingNoInfo(trackingNo));
        }
        for (ExtrusionProcessInfo proc : procs) {
            //Extrusion process in
            for (ProcessMaterialStackInfo matStack : proc.getMaterialsIn()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(matStack.getMaterial().getId());
                Preconditions.checkNotNull(currentBalance,  "Material was consumed by Cutting process but never produced. mat=" + currentBalance.getMaterial().getName());
                currentBalance.setQuantityConsumed(currentBalance.getQuantityConsumed().add(matStack.getQuantity()));
                currentBalance.setQuantityRemaining(currentBalance.getQuantityRemaining().subtract(matStack.getQuantity()));
            }

            //Extrusion process out
            for (ProcessMaterialStackInfo matStack : proc.getMaterialsOut()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(matStack.getMaterial().getId());
                if (null == currentBalance) {
                    LOG.debug("Creating new material balance stack for material={}, source=Extrusion", matStack.getMaterial().getName());
                    currentBalance = new MaterialBalanceStackInfo();
                    currentBalance.setMaterial(matStack.getMaterial());
                    currentBalance.setQuantityWithdrawn(matStack.getQuantity());
                    currentBalance.setQuantityRemaining(matStack.getQuantity());
                    currentBalance.setSource(MaterialSource.EXTRUSION);
                    materialBalance.put(matStack.getMaterial().getId(), currentBalance);
                } else {
                    currentBalance.setQuantityWithdrawn(currentBalance.getQuantityWithdrawn().add(matStack.getQuantity()));
                    currentBalance.setQuantityRemaining(currentBalance.getQuantityRemaining().add(matStack.getQuantity()));
                }
            }
        }
    }

    private void processCuttingProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNosString) {
        //Subtract the materials used by cutting processes
        Iterable<String> trackingNos = tiago.split(trackingNosString);
        List<CuttingProcessInfo> procs = Lists.newArrayList();
        for (String trackingNo : trackingNos) {
            procs.addAll(cutting.findByWorkOrder_TrackingNoInfo(trackingNo));
        }
        for (CuttingProcessInfo proc : procs) {
            ProcessMaterialStackInfo rollIn = proc.getRollIn();

            MaterialBalanceStackInfo mbsInfo = materialBalance.get(rollIn.getMaterial().getId());
            Preconditions.checkNotNull(mbsInfo, "Material was consumed by Cutting process but never produced. mat=" + rollIn.getMaterial().getName());
            mbsInfo.setQuantityConsumed(mbsInfo.getQuantityConsumed().add(ONE));
            mbsInfo.setQuantityRemaining(mbsInfo.getQuantityRemaining().subtract(ONE));
        }
    }

    @Override
    public List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNos, final MaterialSource source) {
        Map<Long, MaterialBalanceStackInfo> map = Maps.newHashMap();
        switch(source) {
        case RAW:
            processWarehouseProcesses(map, trackingNos);
            processMixingProcesses(map, trackingNos);
            break;
        case MIXING:
            processWarehouseProcesses(map, trackingNos);
            processMixingProcesses(map, trackingNos);
            processExtrusionProcesses(map, trackingNos);
            break;
        default:
            throw new IllegalArgumentException("Unsupported material source: " + source);
        }

        LOG.debug("Filtering stacks. source={}", source);
        return Lists.newArrayList(Collections2.filter(map.values(), new Predicate<MaterialBalanceStackInfo>() {
            @Override
            public boolean apply(MaterialBalanceStackInfo input) {
                return input.getSource() == source;
            }
        }));
    }
}
