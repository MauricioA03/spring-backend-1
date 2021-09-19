/**
 * @author: Alex Yerson Gonzales Meneses.
 */

package com.sales.market.service.purchases;

import com.sales.market.model.ItemInventory;

import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.purchases.ItemInventoryRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ItemInventoryServiceImpl extends GenericServiceImpl<ItemInventory> implements ItemInventoryService {
    private final ItemInventoryRepository repository;

    public ItemInventoryServiceImpl(ItemInventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ItemInventory> getRepository() {
        return repository;
    }
}