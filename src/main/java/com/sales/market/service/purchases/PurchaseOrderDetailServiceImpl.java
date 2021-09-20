package com.sales.market.service.purchases;

import com.sales.market.model.purchases.PurchaseOrderDetail;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.purchases.PurchaseOrderDetailRepository;
import com.sales.market.service.GenericServiceImpl;

import org.springframework.stereotype.Service;

/**
 * @author arturo
 */
@Service
public class PurchaseOrderDetailServiceImpl extends GenericServiceImpl<PurchaseOrderDetail> implements PurchaseOrderDetailService {
    private final PurchaseOrderDetailRepository repository;

    public PurchaseOrderDetailServiceImpl(PurchaseOrderDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<PurchaseOrderDetail> getRepository() {
        return repository;
    }


}
