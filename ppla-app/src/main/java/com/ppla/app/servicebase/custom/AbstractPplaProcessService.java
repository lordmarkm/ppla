package com.ppla.app.servicebase.custom;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.PplaUser;
import com.ppla.app.models.PplaWorkOrder;
import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.PplaUserService;
import com.ppla.app.services.PplaWorkOrderService;
import com.ppla.app.services.custom.impl.MappingService;
import com.ppla.core.dto.process.BasePplaProcessInfo;

public abstract class AbstractPplaProcessService<E extends BasePplaProcess, D extends BasePplaProcessInfo, R extends BasePplaProcessService<E>>
    extends MappingService<E, D> {

    @Autowired
    protected R repo;

    @Autowired
    private PplaUserService users;

    @Autowired
    private PplaWorkOrderService workOrders;

    public AbstractPplaProcessService(Class<E> entityClass, Class<D> dtoClass) {
        super(entityClass, dtoClass);
    }

    public static List<BasePplaProcessInfo> sortByDate(List<BasePplaProcessInfo> dtos) {
        Collections.sort(dtos, new Comparator<BasePplaProcessInfo>() {
            @Override
            public int compare(BasePplaProcessInfo o1, BasePplaProcessInfo o2) {
                return o1.getDateStarted().compareTo(o2.getDateStarted());
            }
        });
        return dtos;
    }

    public D findOneInfo(Long id) {
        return toDto(repo.findOne(id));
    }

    public List<D> findByWorkOrder_TrackingNoInfo(String trackingNo) {
        return toDto(repo.findByWorkOrder_TrackingNo(trackingNo));
    }

    public D save(String username, D processInfo) {
        E entity = toEntity(processInfo);
        if (entity.getDateStarted() == null) {
            PplaUser actor = users.findByUsername(username);
            entity.setActor(actor);

            PplaWorkOrder workOrder = workOrders.findByTrackingNo(processInfo.getWorkOrderTrackingNo());
            entity.setWorkOrder(workOrder);

            entity.setDateStarted(DateTime.now());
        }

        E saved = repo.save(entity);
        return toDto(saved);
    }
}
