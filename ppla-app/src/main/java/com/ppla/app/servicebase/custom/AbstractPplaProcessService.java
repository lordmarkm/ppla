package com.ppla.app.servicebase.custom;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.PplaUserService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.tyrael.commons.mapper.service.MappingService;

public abstract class AbstractPplaProcessService<E extends BasePplaProcess, D extends BasePplaProcessInfo, R extends BasePplaProcessService<E>>
    extends MappingService<E, D> {

    @Autowired
    protected R repo;

    @Autowired
    private PplaUserService users;

    @Autowired
    private PplaWorkOrderService workOrders;

    public static List<BasePplaProcessInfo> sortByDate(List<BasePplaProcessInfo> dtos) {
        Collections.sort(dtos, new Comparator<BasePplaProcessInfo>() {
            @Override
            public int compare(BasePplaProcessInfo o1, BasePplaProcessInfo o2) {
                return o2.getDateStarted().compareTo(o1.getDateStarted());
            }
        });
        return dtos;
    }

    public D findOneInfo(Long id) {
        return toDto(repo.findOne(id));
    }

    public List<D> findByWorkOrder_TrackingNoInInfo(String trackingNosString) {
        List<String> trackingNoList = Arrays.asList(trackingNosString.split(","));
        return toDto(repo.findByWorkOrder_TrackingNoIn(trackingNoList));
    }

    public List<D> findByWorkOrder_TrackingNoInfo(String trackingNo) {
        return toDto(repo.findByWorkOrder_TrackingNo(trackingNo));
    }

    public D saveInfo(D processInfo) {
        if (processInfo.getDateStarted() == null) {
            processInfo.setDateStarted(DateTime.now());
        }
        E saved = repo.save(toEntity(processInfo));
        return toDto(saved);
    }
}
