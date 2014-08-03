package com.ppla.app.services.machine;

import com.ppla.app.models.machine.Mixer;
import com.ppla.app.servicebase.BasePplaMachineService;
import com.ppla.app.services.machine.custom.MixerServiceCustom;

/**
 * @author mbmartinez
 */
public interface MixerService extends MixerServiceCustom, BasePplaMachineService<Mixer> {
}
