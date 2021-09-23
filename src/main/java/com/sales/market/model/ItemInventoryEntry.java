/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.model;

import com.sales.market.dto.ItemInventoryDto;
import com.sales.market.dto.ItemInventoryEntryDto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class ItemInventoryEntry extends ModelBase<ItemInventoryEntryDto>{

    @OneToOne
    private ItemInventory itemInventory;
    private MovementType movementType;
    private BigDecimal quantity; // represent sale or buy instances quantity
    private String itemInstanceSkus; //represents a list of the sku of the involved item instances

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(ItemInventory itemInventory) {
        this.itemInventory = itemInventory;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getItemInstanceSkus() {
        return itemInstanceSkus;
    }

    public void setItemInstanceSkus(String itemInstanceSkus) {
        this.itemInstanceSkus = itemInstanceSkus;
    }
}
