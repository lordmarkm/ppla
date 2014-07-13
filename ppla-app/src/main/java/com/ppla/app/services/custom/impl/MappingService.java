package com.ppla.app.services.custom.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

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
}
