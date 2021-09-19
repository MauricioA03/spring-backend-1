package com.sales.market.model.purchases;

import com.sales.market.model.ModelBase;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PurchaseOrderPayment extends ModelBase {

    private String description;

    //MONTOPAGO
    private BigDecimal payAmount;

    //CLASEPAGO
    @Enumerated(EnumType.STRING)
    private PurchaseOrderPaymentKind purchaseOrderPaymentKind;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private PurchaseOrder purchaseOrder;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public PurchaseOrderPaymentKind getPurchaseOrderPaymentKind() {
        return purchaseOrderPaymentKind;
    }

    public void setPurchaseOrderPaymentKind(PurchaseOrderPaymentKind purchaseOrderPaymentKind) {
        this.purchaseOrderPaymentKind = purchaseOrderPaymentKind;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
