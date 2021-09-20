/**
<<<<<<< HEAD
 * @author: Samuel Bazaolto
=======
 * @author: Diego Marcelo Choque Ramirez
>>>>>>> cbb3058ff93ca81481e924a012cdc9ddf37434f8
 */

package com.sales.market.service.purchases;

import com.sales.market.model.Item;
import com.sales.market.model.purchases.ProviderItem;
import com.sales.market.repository.purchases.ProviderItemRepository;
import com.sales.market.repository.GenericRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProviderItemServiceImpl extends GenericServiceImpl<ProviderItem> implements ProviderItemService {
    private final ProviderItemRepository repository;

    public ProviderItemServiceImpl(ProviderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ProviderItem> getRepository() {
        return repository;
    }

    @Override
    public ProviderItem getMinProviderItems(Item item) {
        return repository.getMinProviderItems(item);
    }
}
