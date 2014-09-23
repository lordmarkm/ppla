package com.ppla.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppla.app.models.PplaProduct;

/**
 * 
 * @author Mark
 *
 */
public interface PplaProductService extends JpaRepository<PplaProduct, Long> {

    /**
     * Returns the product whose list id matches the provided value.
     * List ID is a field maintained by quickbooks and indexed by InventoryItem.
     * Soft reference because inventory items may be deleted without affecting past
     * records of PPLA MES, but really because this would be a circular ref.
     */
    PplaProduct findByInventoryItemListId(String listId);

}
