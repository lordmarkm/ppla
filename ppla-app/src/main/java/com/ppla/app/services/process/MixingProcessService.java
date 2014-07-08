package com.ppla.app.services.process;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.process.MixingProcess;

/**
 * @author Mark
 */
public interface MixingProcessService extends JpaRepository<MixingProcess, Long> {

}
