package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.ppla.app.models.machine.Machine;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMachineService<M extends Machine<?>>
    extends BasePplaService<M, Long> {

    List<M> findByDeleted(boolean deleted, Sort sort);

}
