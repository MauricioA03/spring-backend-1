package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.purchases.CustomerDiscountRule;
import com.sales.market.model.purchases.DiscountRuleState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDiscountRuleDto extends DtoBase<CustomerDiscountRule> {
    private String name;
    private DiscountRuleState discountRuleState;
    private Date activationDate = new Date();
    private Date expirationDate;
    private String notes;
    private BigDecimal amount;
    private List<CustomerDiscountDto> discounts = new ArrayList<CustomerDiscountDto>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountRuleState getDiscountRuleState() {
        return discountRuleState;
    }

    public void setDiscountRuleState(DiscountRuleState discountRuleState) {
        this.discountRuleState = discountRuleState;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<CustomerDiscountDto> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<CustomerDiscountDto> discounts) {
        this.discounts = discounts;
    }
}