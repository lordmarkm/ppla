package com.ppla.app.servicebase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.machine.Machine;
import com.ppla.core.dto.machine.MachineInfo;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMachineService<M extends Machine>
    extends JpaRepository<M, Long> {

}
