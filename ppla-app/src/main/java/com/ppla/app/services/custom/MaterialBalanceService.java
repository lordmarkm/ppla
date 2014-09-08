package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.core.dto.material.MaterialBalanceStackInfo;
import com.ppla.core.reference.MaterialSource;

/**
 * @author mbmartinez
 */
public interface MaterialBalanceService {

    List<MaterialBalanceStackInfo> computeMaterialBalance(String workOrderTrackingNo);
    List<MaterialBalanceStackInfo> computeMaterialBalance(String trackingNos, MaterialSource source);

}
