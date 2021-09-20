/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.service;

import com.sales.market.model.ItemInventory;

import java.util.List;
import java.util.Optional;

public interface ItemInventoryService extends GenericService<ItemInventory> {
    Optional<List<ItemInventory>> checkInventory();
}