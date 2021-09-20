package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.purchases.ActionRequired;
import com.sales.market.model.purchases.PurchaseOrder;

public class ActionRequiredDto extends DtoBase<ActionRequired> {

    private PurchaseOrderDto purchaseOrder;
    private String notes;

    public PurchaseOrderDto getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderDto purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}