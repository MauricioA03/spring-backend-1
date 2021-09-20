/**
<<<<<<< HEAD
 * @author: Samuel Bazoalto
=======
 * @author: Diego Marcelo Choque Ramirez
>>>>>>> cbb3058ff93ca81481e924a012cdc9ddf37434f8
 */

package com.sales.market.repository.purchases;

import com.sales.market.model.Item;
import com.sales.market.model.purchases.ProviderItem;
import com.sales.market.repository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProviderItemRepository extends GenericRepository<ProviderItem> {
    @Query("select p from ProviderItem p where p.price=(select MIN(p.price) from p where p.item=:item) and p.item =:item")
    ProviderItem getMinProviderItems(@Param("item") Item item);
}
