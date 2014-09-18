package com.ppla.app.servicebase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ppla.app.models.process.MachineProcess;

/**
 * @author mbmartinez
 * @param <P>
 */
public interface BasePplaMachineProcessService<P extends MachineProcess> 
    extends BasePplaProcessService<P> {

    Page<P> findByMachine_Id(Long machineId, Pageable page);

}
