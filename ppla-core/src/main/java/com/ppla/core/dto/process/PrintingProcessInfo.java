package com.ppla.core.dto.process;

import com.ppla.core.reference.ProcessType;

/**
 * @author mbmartinez
 */
public class PrintingProcessInfo extends BasePplaProcessInfo {

    @Override
    public ProcessType getType() {
        return ProcessType.PRINTING;
    }

}
