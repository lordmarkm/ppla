package com.ppla.app.services.custom.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ppla.app.services.custom.MaterialBalanceService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.material.MaterialBalanceStackInfo;
import com.ppla.core.dto.material.RawMaterialStackInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;
import com.ppla.core.reference.MaterialSource;

@Service
public class MaterialBalanceServiceImpl implements MaterialBalanceService {

    @Autowired
    private WarehouseProcessService warehouse;

    @Override
    public List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNo) {
        Map<Long, MaterialBalanceStackInfo> materialBalance = Maps.newHashMap();
        processWarehouseProcesses(materialBalance, trackingNo);
        return Lists.newArrayList(materialBalance.values());
    }

    private void processWarehouseProcesses(Map<Long, MaterialBalanceStackInfo> materialBalance,
        String trackingNo) {
        List<WarehouseProcessInfo> procs = warehouse.findByWorkOrder_TrackingNoInfo(trackingNo);
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
}
