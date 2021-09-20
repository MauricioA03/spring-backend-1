/**
 * @author: Samuel Bazaolto
 */

package com.sales.market.service.purchases;

import com.sales.market.model.purchases.Customer;
import com.sales.market.repository.purchases.CustomerRepository;
import com.sales.market.repository.GenericRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Customer> getRepository() {
        return repository;
    }
}
