package com.ppla.app.services.machine;

import com.ppla.app.models.machine.Extruder;
import com.ppla.app.servicebase.BasePplaMachineService;
import com.ppla.app.services.machine.custom.ExtruderServiceCustom;

/**
 * @author mbmartinez
 */
public interface ExtruderService extends ExtruderServiceCustom, BasePplaMachineService<Extruder> {
}
