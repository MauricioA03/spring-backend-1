/**
 * @author: Samuel Bazaolto
 */

package com.sales.market.service.purchases;

import com.sales.market.model.purchases.CustomerDiscount;
import com.sales.market.repository.purchases.CustomerDiscountRepository;
import com.sales.market.repository.GenericRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerDiscountServiceImpl extends GenericServiceImpl<CustomerDiscount> implements CustomerDiscountService {
    private final CustomerDiscountRepository repository;

    public CustomerDiscountServiceImpl(CustomerDiscountRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<CustomerDiscount> getRepository() {
        return repository;
    }
}
