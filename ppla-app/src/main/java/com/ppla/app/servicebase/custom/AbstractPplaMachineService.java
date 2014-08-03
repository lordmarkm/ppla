package com.ppla.app.servicebase.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppla.app.models.machine.Machine;
import com.ppla.app.servicebase.BasePplaMachineService;
import com.ppla.app.servicebase.BasePplaMachineServiceCustom;
import com.ppla.app.services.custom.impl.MappingService;
import com.ppla.core.dto.machine.MachineInfo;

/**
 * @author mbmartinez
 * @param <E>
 * @param <D>
 * @param <R>
 */
public abstract class AbstractPplaMachineService<E extends Machine<?>, D extends MachineInfo, R extends BasePplaMachineService<E>>
    extends MappingService<E, D> implements BasePplaMachineServiceCustom<D> {

    @Autowired
    protected R repo;

    public AbstractPplaMachineService(Class<E> entityClass, Class<D> dtoClass) {
        super(entityClass, dtoClass);
    }

    @Override
    public List<D> findAllInfo() {
        return toDto(repo.findAll());
    }

    @Override
    public D findOneInfo(Long id) {
        return toDto(repo.findOne(id));
    }

    @Override
    public D saveInfo(D info) {
        return toDto(repo.save(toEntity(info)));
    }

}
