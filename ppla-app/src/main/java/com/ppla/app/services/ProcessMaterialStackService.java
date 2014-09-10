package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.material.ProcessMaterialStack;
import com.ppla.app.services.custom.ProcessMaterialStackServiceCustom;

/**
 * @author mbmartinez
 */
public interface ProcessMaterialStackService extends JpaRepository<ProcessMaterialStack, Long>,
    ProcessMaterialStackServiceCustom {

    ProcessMaterialStack findByTag(String tag);

}
