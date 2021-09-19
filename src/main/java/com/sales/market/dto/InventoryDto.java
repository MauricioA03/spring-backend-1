/**
 * @author: Alex Yerson Gonzales Meneses.
 */

package com.sales.market.dto;

import com.sales.market.model.ItemInventory;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class InventoryDto extends DtoBase<ItemInventory> {
    private BigDecimal stockQuantity;
    private BigDecimal lowerBoundThreshold;
    private BigDecimal upperBoundThreshold;
    private BigDecimal totalPrice;

    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getLowerBoundThreshold() {
        return lowerBoundThreshold;
    }

    public void setLowerBoundThreshold(BigDecimal lowerBoundThreshold) {
        this.lowerBoundThreshold = lowerBoundThreshold;
    }

    public BigDecimal getUpperBoundThreshold() {
        return upperBoundThreshold;
    }

    public void setUpperBoundThreshold(BigDecimal upperBoundThreshold) {
        this.upperBoundThreshold = upperBoundThreshold;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}