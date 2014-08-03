package com.ppla.app.services.machine.custom.impl;

import com.ppla.app.models.machine.Printer;
import com.ppla.app.servicebase.custom.AbstractPplaMachineService;
import com.ppla.app.services.machine.PrinterService;
import com.ppla.app.services.machine.custom.MixerServiceCustom;
import com.ppla.core.dto.machine.MachineInfo;

/**
 * @author mbmartinez
 */
public class PrinterServiceCustomImpl extends AbstractPplaMachineService<Printer, MachineInfo, PrinterService> 
    implements MixerServiceCustom {

    public PrinterServiceCustomImpl() {
        super(Printer.class, MachineInfo.class);
    }

}
