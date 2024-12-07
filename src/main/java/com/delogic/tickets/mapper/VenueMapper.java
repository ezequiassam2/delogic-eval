package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Venue;
import com.delogic.tickets.dto.VenueDTO;

public interface VenueMapper {
    VenueDTO toDTO(Venue venue);
}