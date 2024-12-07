package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Sale;
import com.delogic.tickets.dto.SaleDTO;

public interface SaleMapper {
    SaleDTO toDTO(Sale sale);
}