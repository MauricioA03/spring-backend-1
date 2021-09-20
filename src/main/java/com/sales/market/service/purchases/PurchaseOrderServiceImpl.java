/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.service.purchases;

import com.sales.market.model.ItemInventory;
import com.sales.market.model.purchases.*;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.purchases.PurchaseOrderRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl extends GenericServiceImpl<PurchaseOrder> implements PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    private final ActionRequiredService actionRequiredService;
    private final ProviderItemService providerItemService;
    private final PurchaseOrderDetailService purchaseOrderDetailService;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository repository, ActionRequiredService actionRequiredService, ProviderItemService providerItemService, PurchaseOrderDetailService purchaseOrderDetailService) {
        this.repository = repository;
        this.actionRequiredService = actionRequiredService;
        this.providerItemService = providerItemService;
        this.purchaseOrderDetailService = purchaseOrderDetailService;
    }

    @Override
    protected GenericRepository<PurchaseOrder> getRepository() {
        return repository;
    }

    @Override
    public PurchaseOrder changeState(Long id, String notes) {
        PurchaseOrder purchaseOrder = findById(id);
        purchaseOrder.setState(PurchaseOrderState.PEN);
        save(purchaseOrder);

        ActionRequired actionRequired = new ActionRequired();
        actionRequired.setPurchaseOrder(purchaseOrder);
        actionRequired.setNotes(notes);
        actionRequiredService.save(actionRequired);

        return purchaseOrder;
    }

    @Override
    public Optional<List<PurchaseOrder>> orderPurchase(Optional<List<ItemInventory>> items) {
        List<PurchaseOrderDetail>orderDetails = getOrderDetails(items);

        return Optional.empty();
    }

    private List<PurchaseOrderDetail> getOrderDetails(Optional<List<ItemInventory>> items){
        List<PurchaseOrderDetail> orderDetails = new ArrayList<>();
        items.orElse(Collections.emptyList()).forEach(itemInventory -> {
            BigDecimal quantity = itemInventory.getUpperBoundThreshold().subtract(itemInventory.getStockQuantity());
            ProviderItem providerItem = providerItemService.getMinProviderItems(itemInventory.getItem());

            PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
            purchaseOrderDetail.setItem(itemInventory.getItem());
            purchaseOrderDetail.setProviderItemCode(providerItem.getProviderItemCode());
            purchaseOrderDetail.setTotalAmount(quantity.multiply(providerItem.getPrice()));
            purchaseOrderDetail.setMeasureUnit(providerItem.getMeasureUnit());
            purchaseOrderDetail.setItemCode(itemInventory.getItem().getCode());
            purchaseOrderDetail.setQuantity(quantity);

            orderDetails.add(purchaseOrderDetail);
        });

        return orderDetails;
    }
}