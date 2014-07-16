package com.ppla.app.servicebase.custom;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.process.BasePplaProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.PplaPersonService;
import com.ppla.app.services.custom.impl.MappingService;
import com.ppla.core.dto.process.BasePplaProcessInfo;

public abstract class AbstractPplaProcessService<E extends BasePplaProcess, D extends BasePplaProcessInfo>
    extends MappingService<E, D> {

    @Autowired
    private PplaPersonService persons;

    public abstract BasePplaProcessService<E> getRepo();
    
    public AbstractPplaProcessService(Class<E> entityClass, Class<D> dtoClass) {
        super(entityClass, dtoClass);
    }

    protected D save(Principal principal, D processInfo) {
        E entity = toEntity(processInfo);
//        entity.setActor(actor);
//        entity.setDateStarted(dateStarted);
//        entity.setWorkOrder(workOrder);

        E saved = getRepo().save(entity);
        return toDto(saved);
    }
}
