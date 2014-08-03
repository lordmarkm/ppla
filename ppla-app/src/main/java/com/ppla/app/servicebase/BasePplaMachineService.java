package com.ppla.app.servicebase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.machine.Machine;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMachineService<M extends Machine<?>>
    extends JpaRepository<M, Long> {
}
