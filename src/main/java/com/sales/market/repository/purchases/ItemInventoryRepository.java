/**
 * @author: Alex Yerson Gonzales Meneses.
 */

package com.sales.market.repository.purchases;

import com.sales.market.model.ItemInventory;
import com.sales.market.repository.GenericRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemInventoryRepository extends GenericRepository<ItemInventory> {
    @Query("FROM ItemInventory AS i WHERE i.stockQuantity < i.lowerBoundThreshold")
    Optional<ItemInventory> rescueItemsStock();

}