/**
 * @author: Diego Marcelo Choque Ramirez
 */

package com.sales.market.controller.purchases;

import com.sales.market.controller.GenericController;
import com.sales.market.dto.purchaseDto.PurchaseOrderDto;
import com.sales.market.model.purchases.PurchaseOrder;
import com.sales.market.service.GenericService;
import com.sales.market.service.purchases.PurchaseOrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/purchaseOrders")
public class PurchaseOrderController extends GenericController<PurchaseOrder, PurchaseOrderDto> {
    private PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @PreAuthorize("hasRole('SUPERVISOR')")
    @PostMapping("/changeOrder/{orderId}")
    public PurchaseOrder changeOrder(@RequestBody String notes, @PathVariable("orderId") @NotNull Long id){
        return service.changeState(id, notes);
    }
}
