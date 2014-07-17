package com.ppla.app.servicebase.custom;

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

public abstract class AbstractPplaProcessService<E extends BasePplaProcess, D extends BasePplaProcessInfo>
    extends MappingService<E, D> {

    @Autowired
    private PplaUserService users;

    @Autowired
    private PplaWorkOrderService workOrders;

    public abstract BasePplaProcessService<E> getRepo();
    
    public AbstractPplaProcessService(Class<E> entityClass, Class<D> dtoClass) {
        super(entityClass, dtoClass);
    }

    protected D save(String username, D processInfo) {
        E entity = toEntity(processInfo);
        if (entity.getDateStarted() == null) {
            PplaUser actor = users.findByUsername(username);
            entity.setActor(actor);

            PplaWorkOrder workOrder = workOrders.findByTrackingNo(processInfo.getWorkOrderTrackingNo());
            entity.setWorkOrder(workOrder);

            entity.setDateStarted(DateTime.now());
        }

        E saved = getRepo().save(entity);
        return toDto(saved);
    }
}
