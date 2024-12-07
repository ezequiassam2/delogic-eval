package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.Listing;
import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.mapper.DateMapper;
import com.delogic.tickets.mapper.EventMapper;
import com.delogic.tickets.mapper.ListingMapper;
import com.delogic.tickets.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ListingMapperImpl implements ListingMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private DateMapper dateMapper;

    @Override
    public ListingDTO toDTO(Listing listing) {
        if (listing == null) {
            return null;
        }
        return ListingDTO.builder()
                .id(listing.getId())
                .seller(userMapper.toDTO(listing.getSeller()))
                .event(eventMapper.toDTO(listing.getEvent()))
                .date(dateMapper.toDTO(listing.getDate()))
                .numberOfTickets(listing.getNumberOfTickets())
                .pricePerTicket(listing.getPricePerTicket())
                .totalPrice(listing.getTotalPrice())
                .timestamp(listing.getTimestamp().toLocalDateTime())
                .build();
    }
}