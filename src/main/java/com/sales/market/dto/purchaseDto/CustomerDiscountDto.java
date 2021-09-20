package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.purchases.Customer;
import com.sales.market.model.purchases.CustomerDiscount;
import com.sales.market.model.purchases.CustomerDiscountRule;


public class CustomerDiscountDto extends DtoBase<CustomerDiscount> {

    private CustomerDiscountRule discountRule;
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