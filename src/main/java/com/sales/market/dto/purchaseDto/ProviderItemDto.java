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

    public String getProviderItemCode() {
        return providerItemCode;
    }

    public void setProviderItemCode(String providerItemCode) {
        this.providerItemCode = providerItemCode;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}