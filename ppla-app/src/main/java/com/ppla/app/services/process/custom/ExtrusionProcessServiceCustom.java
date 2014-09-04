package com.ppla.app.services.process.custom;

import org.springframework.transaction.annotation.Transactional;

import com.ppla.app.servicebase.BasePplaProcessServiceCustom;
import com.ppla.core.dto.process.ExtrusionProcessInfo;

/**
 * @author mbmartinez
 */
@Transactional
public interface ExtrusionProcessServiceCustom extends BasePplaProcessServiceCustom<ExtrusionProcessInfo> {

}
