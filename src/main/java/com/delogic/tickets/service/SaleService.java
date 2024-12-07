package com.delogic.tickets.service;

import com.delogic.tickets.domain.Sale;
import com.delogic.tickets.dto.SaleDTO;
import com.delogic.tickets.mapper.SaleMapper;
import com.delogic.tickets.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends BaseService<Sale, SaleDTO> {

    private final SaleMapper saleMapper;

    @Autowired
    public SaleService(SaleRepository repository, SaleMapper saleMapper) {
        super(repository);
        this.saleMapper = saleMapper;
    }

    @Override
    protected SaleDTO toDTO(Sale entity) {
        return this.saleMapper.toDTO(entity);
    }
}