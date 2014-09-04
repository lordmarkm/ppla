package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ppla.core.dto.process.BasePplaProcessInfo;

/**
 * @author Mark
 * @param <D>
 */
@Transactional
public interface BasePplaProcessServiceCustom<D extends BasePplaProcessInfo> {

    D findOneInfo(Long id);
    D saveInfo(D processInfo);
    D startInfo(D processInfo);
    D endInfo(D processInfo);
    List<D> findByWorkOrder_TrackingNoInInfo(String trackingNos);
    List<D> findByWorkOrder_TrackingNoInfo(String trackingNo);

}
