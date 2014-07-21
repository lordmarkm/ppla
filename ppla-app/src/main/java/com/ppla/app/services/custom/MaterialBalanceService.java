package com.ppla.app.services.custom;

import java.util.List;

import com.ppla.core.dto.material.MaterialBalanceStackInfo;

/**
 * @author mbmartinez
 */
public interface MaterialBalanceService {

    List<MaterialBalanceStackInfo> computeMaterialBalance(String workOrderTrackingNo);

}
