package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.tyrael.commons.mapper.dto.PageInfo;

/**
 * @author Mark
 * @param <D>
 */
@Transactional
public interface BasePplaProcessServiceCustom<D extends BasePplaProcessInfo> {

    PageInfo<D> pageInfoByMachineId(Long machineId, PageRequest pageRequest);
    D findOneInfo(Long id);
    D saveInfo(D processInfo);
    D startInfo(D processInfo);
    D endInfo(D processInfo);
    List<D> findByWorkOrder_TrackingNoInInfo(String trackingNos);
    List<D> findByWorkOrder_TrackingNoInfo(String trackingNo);

}
