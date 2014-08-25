package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.material.PplaMaterial;
import com.ppla.core.reference.MaterialSource;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMaterialService<M extends PplaMaterial> 
    extends JpaRepository<M, Long> {

    List<M> findByDeleted(Boolean deleted);
    List<M> findBySourceAndDeleted(MaterialSource source, Boolean deleted);

}
