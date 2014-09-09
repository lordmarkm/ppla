package com.ppla.app.services.process.custom;

import com.ppla.app.servicebase.BasePplaProcessServiceCustom;
import com.ppla.core.dto.process.PrintingProcessInfo;

/**
 * @author mbmartinez
 */
public interface PrintingProcessServiceCustom extends BasePplaProcessServiceCustom<PrintingProcessInfo> {

    PrintingProcessInfo findInfoByRollTag(String tag);

}
