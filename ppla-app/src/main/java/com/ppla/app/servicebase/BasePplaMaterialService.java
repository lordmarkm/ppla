package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaMaterial;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMaterialService<M extends PplaMaterial> 
    extends JpaRepository<M, Long> {

    List<M> findByDeleted(Boolean deleted);

}
