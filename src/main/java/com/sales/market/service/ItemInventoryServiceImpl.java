/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.service;

import com.sales.market.model.ItemInventory;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ItemInventoryRepository;
import com.sales.market.service.purchases.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ItemInventoryServiceImpl extends GenericServiceImpl<ItemInventory> implements ItemInventoryService {
    private final ItemInventoryRepository repository;
    private final PurchaseOrderService purchaseOrderService;

    public ItemInventoryServiceImpl(ItemInventoryRepository repository, PurchaseOrderService purchaseOrderService) {
        this.repository = repository;
        this.purchaseOrderService = purchaseOrderService;
    }


    @Override
    protected GenericRepository<ItemInventory> getRepository() {
        return repository;
    }


    @Override
    public Optional<List<ItemInventory>> checkInventory() {
        purchaseOrderService.orderPurchase(repository.getMinItemInventories());
        return repository.getMinItemInventories();
    }
}
