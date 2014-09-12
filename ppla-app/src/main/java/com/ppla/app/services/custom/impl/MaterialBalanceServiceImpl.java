package com.ppla.app.services.custom.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
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

    @Autowired
    private WarehouseProcessService warehouse;

    @Autowired
    private MixingProcessService mixing;

    @Autowired
    private ExtrusionProcessService extrusion;

    @Autowired
    private CuttingProcessService cutting;

    @Override
    public List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNos) {
        //Do raw & process separately in case of id overlap
        Map<Long, MaterialBalanceStackInfo> rawMaterialBalance = Maps.newHashMap();
        processWarehouseProcesses(rawMaterialBalance, trackingNos);

        Map<Long, MaterialBalanceStackInfo> procMaterialBalance = Maps.newHashMap();
        processMixingProcesses(procMaterialBalance, trackingNos);
        processExtrusionProcesses(procMaterialBalance, trackingNos);
        //Printing doesn't really use up materials, so it's not here
        processCuttingProcesses(procMaterialBalance, trackingNos);

        List<MaterialBalanceStackInfo> mats = Lists.newArrayList();
        mats.addAll(rawMaterialBalance.values());
        mats.addAll(procMaterialBalance.values());

        return mats;
    }

    private void processWarehouseProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNos) {

        List<WarehouseProcessInfo> procs = warehouse.findByWorkOrder_TrackingNoInfo(trackingNos);
        for (WarehouseProcessInfo proc : procs) {
            for (RawMaterialStackInfo rawMatStack : proc.getMaterialStacks()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(rawMatStack.getMaterial().getId());
                if (null == currentBalance) {
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

    private void processMixingProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNos) {

        List<MixingProcessInfo> procs = mixing.findByWorkOrder_TrackingNoInfo(trackingNos);
        for (MixingProcessInfo proc : procs) {
            for (ProcessMaterialStackInfo matStack : proc.getMaterialsOut()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(matStack.getMaterial().getId());
                if (null == currentBalance) {
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

    private void processExtrusionProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNos) {
        List<ExtrusionProcessInfo> procs = extrusion.findByWorkOrder_TrackingNoInfo(trackingNos);
        for (ExtrusionProcessInfo proc : procs) {
            for (ProcessMaterialStackInfo matStack : proc.getMaterialsOut()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(matStack.getMaterial().getId());
                if (null == currentBalance) {
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

    private void processCuttingProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance, String trackingNos) {
        //Subtract the materials used by cutting processes
        List<CuttingProcessInfo> procs = cutting.findByWorkOrder_TrackingNoInfo(trackingNos);
        for (CuttingProcessInfo proc : procs) {
            ProcessMaterialStackInfo rollIn = proc.getRollIn();

            MaterialBalanceStackInfo mbsInfo = materialBalance.get(rollIn.getMaterial().getId());
            Preconditions.checkNotNull(mbsInfo, "Material was consumed by Cutting process but never produced. mat=" + rollIn.getMaterial().getName());
            mbsInfo.setQuantityConsumed(mbsInfo.getQuantityConsumed().add(ONE));
        }
    }

    @Override
    public List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNos, MaterialSource source) {
        Map<Long, MaterialBalanceStackInfo> map = Maps.newHashMap();
        switch(source) {
        case MIXING:
            processMixingProcesses(map, trackingNos);
            break;
        default:
            throw new IllegalArgumentException("Unsupported material source: " + source);
        }
        return Lists.newArrayList(map.values());
    }
}
