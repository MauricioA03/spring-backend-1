/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.model.purchases;

import com.sales.market.model.ModelBase;

public class ActionRequired extends ModelBase {
    private PurchaseOrder purchaseOrder;
    private String notes;

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
