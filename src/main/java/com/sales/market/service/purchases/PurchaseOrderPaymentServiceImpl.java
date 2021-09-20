/**
 * @author: Samuel Bazaolto
 */

package com.sales.market.service.purchases;

import com.sales.market.model.purchases.PurchaseOrderPayment;
import com.sales.market.repository.purchases.PurchaseOrderPaymentRepository;
import com.sales.market.repository.GenericRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderPaymentServiceImpl extends GenericServiceImpl<PurchaseOrderPayment> implements PurchaseOrderPaymentService {
    private final PurchaseOrderPaymentRepository repository;

    public PurchaseOrderPaymentServiceImpl(PurchaseOrderPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<PurchaseOrderPayment> getRepository() {
        return repository;
    }
}
