package com.ppla.app.services.process;

import com.ppla.app.models.process.PrintingProcess;
import com.ppla.app.servicebase.BasePplaProcessService;
import com.ppla.app.services.process.custom.PrintingProcessServiceCustom;

/**
 * @author mbmartinez
 */
public interface PrintingProcessService extends BasePplaProcessService<PrintingProcess>,
    PrintingProcessServiceCustom {

}
