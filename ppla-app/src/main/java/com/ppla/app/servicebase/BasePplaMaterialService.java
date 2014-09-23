package com.ppla.app.servicebase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.material.PplaMaterial;
import com.ppla.core.reference.MaterialSource;

/**
 * @author mbmartinez
 * @param <M>
 */
public interface BasePplaMaterialService<M extends PplaMaterial> 
    extends JpaRepository<M, Long> {

    /**
     * Returns the material whose list id matches the provided value.
     * List ID is a field maintained by quickbooks and indexed by InventoryItem.
     * Soft reference because inventory items may be deleted without affecting past
     * records of PPLA MES, but really because this would be a circular ref.
     */
    M findByInventoryItemListId(String listId);

    List<M> findByDeleted(Boolean deleted);
    List<M> findBySourceAndDeleted(MaterialSource source, Boolean deleted);

}
