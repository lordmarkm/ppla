package com.ppla.app.services.process.custom;

import org.springframework.transaction.annotation.Transactional;

import com.ppla.app.servicebase.BasePplaProcessServiceCustom;
import com.ppla.core.dto.process.MixingProcessInfo;

/**
 * @author Mark
 */
@Transactional
public interface MixingProcessServiceCustom extends BasePplaProcessServiceCustom<MixingProcessInfo> {

}
