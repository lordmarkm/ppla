package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.material.ProcessMaterialStack;

/**
 * @author mbmartinez
 */
public interface ProcessMaterialStackService extends JpaRepository<ProcessMaterialStack, Long>{

    ProcessMaterialStack findByTag(String tag);

}
