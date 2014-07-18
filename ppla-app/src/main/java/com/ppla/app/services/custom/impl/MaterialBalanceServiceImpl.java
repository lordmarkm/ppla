package com.ppla.app.services.custom.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.material.RawMaterialStack;
import com.ppla.app.models.process.WarehouseProcess;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.custom.MaterialBalanceService;
import com.ppla.app.services.process.WarehouseProcessService;
import com.ppla.core.dto.material.MaterialBalanceStackInfo;
import com.ppla.core.dto.material.RawMaterialStackInfo;
import com.ppla.core.dto.process.WarehouseProcessInfo;
import com.tyrael.process.mgt.models.material.Material;

@Service
public class MaterialBalanceServiceImpl implements MaterialBalanceService {

    @Autowired
    private WarehouseProcessService warehouse;

    @Override
    public List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNo) {
        Map<Material, MaterialBalanceStackInfo> materialBalance = Maps.newHashMap();
        processWarehouseProcesses(materialBalance, trackingNo);
        return Lists.newArrayList(materialBalance.values());
    }

    private void processWarehouseProcesses(Map<Material, MaterialBalanceStackInfo> materialBalance,
        String trackingNo) {
        List<WarehouseProcessInfo> procs = warehouse.findByWorkOrder_TrackingNoInfo(trackingNo);
        for (WarehouseProcessInfo proc : procs) {
            for (RawMaterialStackInfo rawMatStack : proc.getMaterialStacks()) {
                MaterialBalanceStackInfo currentBalance = materialBalance.get(rawMatStack.getMaterial());
                if (null == currentBalance) {
                    currentBalance = new MaterialBalanceStackInfo();
                    currentBalance.setMaterial(rawMatStack.getMaterial());
                    currentBalance.setQuantityWithdrawn(rawMatStack.getQuantity());
                    currentBalance.setQuantityRemaining(rawMatStack.getQuantity());
                } else {
                    currentBalance.setQuantityWithdrawn(currentBalance.getQuantityWithdrawn().add(rawMatStack.getQuantity()));
                    currentBalance.setQuantityRemaining(currentBalance.getQuantityRemaining().add(rawMatStack.getQuantity()));
                }
            }
        }
    }
}
