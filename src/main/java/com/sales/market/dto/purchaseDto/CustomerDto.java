package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.purchases.Customer;

import java.util.Date;

public class CustomerDto extends DtoBase<Customer> {
    private String number;
    private Date firstPurchase;
    private Date lastPurchase;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getFirstPurchase() {
        return firstPurchase;
    }

    public void setFirstPurchase(Date firstPurchase) {
        this.firstPurchase = firstPurchase;
    }

    public Date getLastPurchase() {
        return lastPurchase;
    }

    public void setLastPurchase(Date lastPurchase) {
        this.lastPurchase = lastPurchase;
    }
}