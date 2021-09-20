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
import java.time.Instant;
import java.util.*;

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
    public void orderPurchase(Optional<List<ItemInventory>> items) {
        Hashtable<Provider, ArrayList<PurchaseOrderDetail>>orderDetails = getOrderDetails(items);
        orderDetails.forEach((provider, details) -> createPurchase(provider, details));
    }

    private void createPurchase(Provider provider, ArrayList<PurchaseOrderDetail> purchaseOrderDetails){
        Random rdn = new Random();
        int value = rdn.nextInt(10000000);
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderNumber(String.valueOf(value));
        purchaseOrder.setDate(Date.from(Instant.now()));
        purchaseOrder.setState(PurchaseOrderState.APR);
        purchaseOrder.setReceivedType(PurchaseOrderReceivedType.RP);
        purchaseOrder.setPaymentStatus(PurchaseOrderPaymentStatus.NO_PAYMENT);
        purchaseOrder.setTotalAmount(new BigDecimal("100"));
        purchaseOrder.setBalanceAmount(BigDecimal.ZERO);
        purchaseOrder.setProviderCode(provider.getCode());
        purchaseOrder.setProvider(provider);
        purchaseOrder.setPurchaseOrderDetailList(purchaseOrderDetails);
        save(purchaseOrder);
    }

    private Hashtable<Provider, ArrayList<PurchaseOrderDetail>> getOrderDetails(Optional<List<ItemInventory>> items){
        Hashtable<Provider, ArrayList<PurchaseOrderDetail>> dictionary = new Hashtable<>();
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

            if (dictionary.containsKey(providerItem.getProvider())){
                dictionary.get(providerItem.getProvider()).add(purchaseOrderDetail);
            } else {
                ArrayList<PurchaseOrderDetail> orders = new ArrayList<>();
                orders.add(purchaseOrderDetail);
                dictionary.put(providerItem.getProvider(), orders);
            }
        });
        return dictionary;
    }
}