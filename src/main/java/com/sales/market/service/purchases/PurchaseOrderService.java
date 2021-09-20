/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.service.purchases;

import com.sales.market.model.ItemInventory;
import com.sales.market.model.purchases.PurchaseOrder;
import com.sales.market.service.GenericService;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService extends GenericService<PurchaseOrder> {
    PurchaseOrder changeState(Long id, String notes);
    void orderPurchase(Optional<List<ItemInventory>> items);
}