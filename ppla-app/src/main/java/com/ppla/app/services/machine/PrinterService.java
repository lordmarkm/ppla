package com.ppla.app.services.machine;

import com.ppla.app.models.machine.Printer;
import com.ppla.app.servicebase.BasePplaMachineService;
import com.ppla.app.services.machine.custom.PrinterServiceCustom;

/**
 * @author mbmartinez
 */
public interface PrinterService extends PrinterServiceCustom, BasePplaMachineService<Printer> {
}
