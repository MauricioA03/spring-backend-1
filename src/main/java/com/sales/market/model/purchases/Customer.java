package com.sales.market.model.purchases;


import com.sales.market.model.ModelBase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends ModelBase {

    private String number;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date firstPurchase;

    @Temporal(value = TemporalType.TIMESTAMP)
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

    public Integer getTotalPurchasedProducts() {
        return totalPurchasedProducts;
    }

    public void setTotalPurchasedProducts(Integer totalPurchasedProducts) {
        this.totalPurchasedProducts = totalPurchasedProducts;
    }

    public BigDecimal getTotalPurchasedAmount() {
        return totalPurchasedAmount;
    }

    public void setTotalPurchasedAmount(BigDecimal totalPurchasedAmount) {
        this.totalPurchasedAmount = totalPurchasedAmount;
    }

    public List<CustomerDiscount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<CustomerDiscount> discounts) {
        this.discounts = discounts;
    }

    //totalarticulosadquiridos
    private Integer totalPurchasedProducts;

    //totalimporteadquirido
    private BigDecimal totalPurchasedAmount;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerDiscount> discounts = new ArrayList<CustomerDiscount>(0);

}
