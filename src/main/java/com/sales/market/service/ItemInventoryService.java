/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.service;

import com.sales.market.model.ItemInventory;

public interface ItemInventoryService extends GenericService<ItemInventory> {
    void checkInventory();
}