/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.dto.purchaseDto;

import com.sales.market.dto.DtoBase;
import com.sales.market.model.Item;
import com.sales.market.model.purchases.MeasureUnit;
import com.sales.market.model.purchases.ProviderItem;


public class ProviderItemDto extends DtoBase<ProviderItem> {
    private String providerItemCode;
    private String providerCode;
    private Item item;
    private String itemCode;
    private MeasureUnit measureUnit;
    private Double price;
}