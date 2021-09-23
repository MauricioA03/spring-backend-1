package com.sales.market.service;

import com.sales.market.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.sales.market.model.ItemInstanceStatus.*;
import static com.sales.market.model.MovementType.*;
import static org.testng.Assert.assertEquals;

@SpringBootTest
public class ItemInventoryServiceImplTest {
    @Autowired
    private ItemInventoryService itemInventoryService;
    @Autowired
    private ItemInventoryEntryService itemInventoryEntryService;
    @Autowired
    private ItemInstanceService itemInstanceService;

    @Test
    public void removeOneItemAndChangeStateOfSCREWED(){
        ItemInventory itemInventory = itemInventoryService.findById(1L);
        ItemInventoryEntry entry = persistirEntry(itemInventory,"SKU-100001",REMOVED,1);
        ItemInventoryEntry entryPersisted = itemInventoryEntryService.save(entry);
        expectedResults(entryPersisted,4,"SKU-100001",SCREWED);
    }

    @Test
    public  void buyOneItemAndChangeStateOfAVAILABLE(){
        ItemInventory itemInventory = itemInventoryService.findById(2L);
        ItemInventoryEntry entry = persistirEntry(itemInventory,"SKU-200006 SKU-200007 SKU-200008", BUY,3);
        ItemInventoryEntry entryPersisted = itemInventoryEntryService.save(entry);
        expectedResults(entryPersisted,8,"SKU-200008",AVAILABLE);
    }

    @Test
    public  void saleOneItemAndChangeStateOfSOLD(){
        ItemInventory itemInventory = itemInventoryService.findById(3L);
        ItemInventoryEntry entry = persistirEntry(itemInventory,"SKU-300001",SALE,1);
        ItemInventoryEntry entryPersisted = itemInventoryEntryService.save(entry);
        expectedResults(entryPersisted,4,"SKU-300001",SOLD);
    }

    private ItemInventoryEntry persistirEntry(ItemInventory itemInventory, String SKU, MovementType movementType, int quantity) {
        ItemInventoryEntry entry = new ItemInventoryEntry();
        entry.setItemInventory(itemInventory);
        entry.setItemInstanceSkus(SKU);
        entry.setMovementType(movementType);
        entry.setQuantity(new BigDecimal(quantity));
        return entry;
    }

    private void expectedResults(ItemInventoryEntry itemInventoryEntry, int itemsAvailable, String Sku, ItemInstanceStatus status) {
        ItemInventory itemInventory = itemInventoryEntry.getItemInventory();
        assertEquals(itemsAvailable,itemInventory.getStockQuantity().intValue());
        ItemInstance itemInstance = itemInstanceService.getByIdentifier(Sku);
        assertEquals(itemInstance.getItemInstanceStatus(),status);
    }
}
