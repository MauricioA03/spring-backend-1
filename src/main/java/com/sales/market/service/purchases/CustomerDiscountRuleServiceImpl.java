/**
 * @author: Samuel Bazaolto
 */

package com.sales.market.service.purchases;

import com.sales.market.model.purchases.CustomerDiscountRule;
import com.sales.market.repository.purchases.CustomerDiscountRuleRepository;
import com.sales.market.repository.GenericRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerDiscountRuleServiceImpl extends GenericServiceImpl<CustomerDiscountRule> implements CustomerDiscountRuleService {
    private final CustomerDiscountRuleRepository repository;

    public CustomerDiscountRuleServiceImpl(CustomerDiscountRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<CustomerDiscountRule> getRepository() {
        return repository;
    }
}
