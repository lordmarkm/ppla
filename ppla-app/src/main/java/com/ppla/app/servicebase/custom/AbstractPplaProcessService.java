package com.ppla.app.servicebase.custom;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ppla.app.models.PplaOrderItem;
import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.PplaOrderItemService;
import com.ppla.core.dto.PplaOrderItemInfo;
import com.ppla.core.dto.process.BasePplaProcessInfo;
import com.tyrael.commons.mapper.service.MappingService;
import com.tyrael.process.mgt.models.order.OrderItem;

public abstract class AbstractPplaProcessService<E extends BasePplaProcess,
    D extends BasePplaProcessInfo,
    R extends BasePplaProcessService<E>>
    extends MappingService<E, D> {

    private static Logger LOG = LoggerFactory.getLogger(AbstractPplaProcessService.class);

    @Autowired
    protected R repo;

    @Autowired
    private PplaOrderItemService orderItemService;

    public static List<BasePplaProcessInfo> sortByDate(List<BasePplaProcessInfo> dtos) {
        Collections.sort(dtos, new Comparator<BasePplaProcessInfo>() {
            @Override
            public int compare(BasePplaProcessInfo o1, BasePplaProcessInfo o2) {
                if (null == o1.getDateStarted()) {
                    return 1;
                } else if (null == o2.getDateStarted()) {
                    return -1;
                }
                return o2.getDateStarted().compareTo(o1.getDateStarted());
            }
        });
        return dtos;
    }

    public D findOneInfo(Long id) {
        E process = repo.findOne(id);
        LOG.debug("Process start date={}", process.getDateStarted());
        D dto = toDto(process);

        List<PplaOrderItem> orderItems = orderItemService.findByWorkOrder(process.getWorkOrder());
        List<PplaOrderItemInfo> orderItemInfos = Lists.newArrayList();

        for (PplaOrderItem order : orderItems) {
            orderItemInfos.add(mapper.map(order, PplaOrderItemInfo.class));
        }
        dto.getWorkOrder().setOrderItems(orderItemInfos);

        return dto;
    }

    public List<D> findByWorkOrder_TrackingNoInInfo(String trackingNosString) {
        List<String> trackingNoList = Arrays.asList(trackingNosString.split(","));
        return toDto(repo.findByWorkOrder_TrackingNoIn(trackingNoList));
    }

    public List<D> findByWorkOrder_TrackingNoInfo(String trackingNo) {
        return toDto(repo.findByWorkOrder_TrackingNo(trackingNo));
    }

    public E save(D processInfo) {
        return repo.save(toEntity(processInfo));
    }

    public E start(D processInfo) {
        processInfo.setDateStarted(DateTime.now());
        return save(processInfo);
    }

    public E end(D processInfo) {
        processInfo.setDateCompleted(DateTime.now());
        if (null != processInfo.getDateStarted()) {
            Period difference = new Period(processInfo.getDateStarted(), processInfo.getDateCompleted());
            processInfo.setTurnaroundTime(PeriodFormat.getDefault().print(difference));
        }
        return save(processInfo);
    }

    public D saveInfo(D processInfo) {
        return toDto(save(processInfo));
    }

    public D startInfo(D processInfo) {
        return toDto(start(processInfo));
    }

    public D endInfo(D processInfo) {
        return toDto(end(processInfo));
    }
}
