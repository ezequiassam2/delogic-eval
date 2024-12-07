package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.Sale;
import com.delogic.tickets.dto.SaleDTO;
import com.delogic.tickets.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    private ListingMapper listingMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private DateMapper dateMapper;

    @Override
    public SaleDTO toDTO(Sale sale) {
        if (sale == null) {
            return null;
        }
        return SaleDTO.builder()
                .id(sale.getId())
                .listing(listingMapper.toDTO(sale.getListing()))
                .seller(userMapper.toDTO(sale.getSeller()))
                .buyer(userMapper.toDTO(sale.getBuyer()))
                .event(eventMapper.toDTO(sale.getEvent()))
                .date(dateMapper.toDTO(sale.getDate()))
                .quantitySold(sale.getQuantitySold())
                .pricePaid(sale.getPricePaid())
                .commissionAmount(sale.getCommissionAmount())
                .timestamp(sale.getTimestamp().toLocalDateTime())
                .build();
    }
}