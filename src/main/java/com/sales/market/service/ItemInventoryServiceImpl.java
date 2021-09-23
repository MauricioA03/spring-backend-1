/**
 * @author: Samuel Bazaolto
 */

package com.sales.market.service;

import com.sales.market.model.*;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.ItemInventoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.sales.market.model.ItemInstanceStatus.*;

@Service
public class ItemInventoryServiceImpl extends GenericServiceImpl<ItemInventory> implements ItemInventoryService {

    private final ItemInventoryRepository itemInventoryRepository;
    private final ItemInstanceService itemInstanceService;

    public ItemInventoryServiceImpl(ItemInventoryRepository itemInventoryRepository, ItemInstanceService itemInstanceService) {
        this.itemInventoryRepository = itemInventoryRepository;
        this.itemInstanceService = itemInstanceService;
    }

    @Override
    protected GenericRepository<ItemInventory> getRepository() {
        return itemInventoryRepository;
    }

    @Override
    public ItemInventory updateInventory(ItemInventoryEntry itemInventoryEntry, MovementType movementType) {
        ItemInventory itemInventory = itemInventoryEntry.getItemInventory();
        BigDecimal quantity = itemInventoryEntry.getQuantity();
        switch (movementType) {
            case SALE:
                itemInventory.setStockQuantity(itemInventory.getStockQuantity().subtract(quantity));
                itemInstanceService.setStateAll(itemInventoryEntry.getItemInstanceSkus(), SOLD);
                break;
            case REMOVED:
                itemInventory.setStockQuantity(itemInventory.getStockQuantity().subtract(quantity));
                itemInstanceService.setStateAll(itemInventoryEntry.getItemInstanceSkus(), SCREWED);
                break;
            case BUY:
                itemInventory.setStockQuantity(itemInventory.getStockQuantity().add(quantity));
                itemInstanceService.saveAllItemBySkus(itemInventoryEntry.getItemInstanceSkus(), itemInventory.getItem());
                break;
        }
        ItemInventory inventory = itemInventoryRepository.save(itemInventory);
        this.save(inventory);
        return inventory;
    }

    @Override
    public ItemInventory save(ItemInventory itemInventory) {
        super.save(itemInventory);
        List<ItemInstance> itemInstanceList =
                itemInstanceService.getItemInstanceByItemAndEqualStatus(itemInventory.getItem(), AVAILABLE);
        itemInventory.setStockQuantity(new BigDecimal(itemInstanceList.size()));
        double totalPrice = itemInstanceList.stream().mapToDouble(ItemInstance::getPrice).sum();
        itemInventory.setTotalPrice(new BigDecimal(totalPrice));
        return itemInventoryRepository.save(itemInventory);
    }
}
