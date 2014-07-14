package com.ppla.app.servicebase;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author mbmartinez
 * @param <E>
 * @param <I>
 */
public interface BasePplaService<E, I extends Serializable> 
    extends JpaRepository<E, I>, QueryDslPredicateExecutor<E> {

}
