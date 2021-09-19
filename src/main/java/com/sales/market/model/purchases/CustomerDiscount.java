package com.sales.market.model.purchases;

import com.sales.market.model.ModelBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class CustomerDiscount extends ModelBase {

    @ManyToOne
    private CustomerDiscountRule discountRule;

    @ManyToOne
    private Customer customer;

    private String discountCode;

    public CustomerDiscountRule getDiscountRule() {
        return discountRule;
    }

    public void setDiscountRule(CustomerDiscountRule discountRule) {
        this.discountRule = discountRule;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
