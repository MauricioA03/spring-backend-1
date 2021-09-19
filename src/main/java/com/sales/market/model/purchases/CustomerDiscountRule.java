package com.sales.market.model.purchases;


import com.sales.market.model.ModelBase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerDiscountRule extends ModelBase {
    private String name;

    @Enumerated(EnumType.STRING)
    private DiscountRuleState discountRuleState;

    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Lob
    private String notes;

    @Column(precision = 13, scale = 2, nullable = false)
    private BigDecimal amount;

    @OneToMany(mappedBy = "discountRule")
    private List<CustomerDiscount> discounts = new ArrayList<CustomerDiscount>(0);

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

    public List<CustomerDiscount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<CustomerDiscount> discounts) {
        this.discounts = discounts;
    }
}
