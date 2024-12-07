package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Listing;
import com.delogic.tickets.dto.ListingDTO;

public interface ListingMapper {
    ListingDTO toDTO(Listing listing);
}