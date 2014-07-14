package com.ppla.app.services.custom.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

/**
 * @author Mark
 *
 * @param <E>
 * @param <D>
 */
public abstract class MappingService<E, D> {

    @Autowired
    private Mapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public MappingService(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    protected D toDto(E entity) {
        return mapper.map(entity, dtoClass);
    }

    protected E toEntity(D dto) {
        return mapper.map(dto, entityClass);
    }

    protected List<D> toDto(Iterable<E> entities) {
        List<D> dtos = Lists.newArrayList();
        for (E entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
