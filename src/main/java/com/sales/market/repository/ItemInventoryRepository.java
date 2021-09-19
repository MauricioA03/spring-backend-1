/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.repository;

import com.sales.market.model.Item;
import com.sales.market.model.ItemInventory;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemInventoryRepository extends GenericRepository<ItemInventory> {
    @Query("FROM ItemInventory i WHERE i.stockQuantity < i.lowerBoundThreshold")
    List<ItemInventory>getMinItemInventories();
}
