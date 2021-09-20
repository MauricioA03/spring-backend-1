package com.sales.market.service.purchases;

import com.sales.market.model.purchases.MeasureUnit;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.purchases.MeasureUnitRepository;
import com.sales.market.service.GenericServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class MeasureUnitServiceImpl extends GenericServiceImpl<MeasureUnit> {
    private final MeasureUnitRepository repository;

    public MeasureUnitServiceImpl(MeasureUnitRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<MeasureUnit> getRepository() {
        return repository;
    }
}
