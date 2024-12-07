package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.Venue;
import com.delogic.tickets.dto.VenueDTO;
import com.delogic.tickets.mapper.VenueMapper;

public class VenueMapperImpl implements VenueMapper {

    @Override
    public VenueDTO toDTO(Venue venue) {
        if (venue == null) {
            return null;
        }
        return VenueDTO.builder()
                .id(venue.getId())
                .name(venue.getName())
                .city(venue.getCity())
                .state(venue.getState())
                .seatingCapacity(venue.getSeatingCapacity())
                .build();
    }
}