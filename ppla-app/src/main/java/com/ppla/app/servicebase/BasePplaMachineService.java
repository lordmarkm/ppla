package com.ppla.app.servicebase;

import com.ppla.app.models.machine.Machine;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMachineService<M extends Machine<?>>
    extends BasePplaService<M, Long> {
}
