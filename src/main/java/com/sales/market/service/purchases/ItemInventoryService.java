/**
 * @author: Alex Yerson Gonzales Meneses.
 */

package com.sales.market.service.purchases;

import com.sales.market.model.ItemInventory;
import com.sales.market.service.GenericService;

import java.util.List;

public interface ItemInventoryService extends GenericService<ItemInventory> {
    List<ItemInventory> checkItemsLowsThresehold();
}