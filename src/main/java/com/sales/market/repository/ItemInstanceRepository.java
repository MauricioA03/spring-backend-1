/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.repository;


import com.sales.market.model.ItemInstance;

public interface ItemInstanceRepository extends GenericRepository<ItemInstance> {
    ItemInstance getByIdentifier(String sku);
}
