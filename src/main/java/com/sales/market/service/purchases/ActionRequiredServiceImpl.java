/**
 * @author: Samuel Bazaolto
 */

package com.sales.market.service.purchases;

import com.sales.market.model.purchases.ActionRequired;
import com.sales.market.repository.purchases.ActionRequiredRepository;
import com.sales.market.repository.GenericRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ActionRequiredServiceImpl extends GenericServiceImpl<ActionRequired> implements ActionRequiredService {
    private final ActionRequiredRepository repository;

    public ActionRequiredServiceImpl(ActionRequiredRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ActionRequired> getRepository() {
        return repository;
    }
}
