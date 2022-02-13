package com.wasathdev.inventoryservice.repository;

import com.wasathdev.inventoryservice.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem,Long> {

    Optional<InventoryItem> findByProductCode(String productCode);
}
