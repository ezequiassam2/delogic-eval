package com.delogic.tickets.service;

import com.delogic.tickets.domain.Venue;
import com.delogic.tickets.dto.VenueDTO;
import com.delogic.tickets.mapper.VenueMapper;
import com.delogic.tickets.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService extends BaseService<Venue, VenueDTO> {

    private final VenueMapper venueMapper;

    @Autowired
    public VenueService(VenueRepository repository, VenueMapper venueMapper) {
        super(repository);
        this.venueMapper = venueMapper;
    }

    @Override
    protected VenueDTO toDTO(Venue entity) {
        return this.venueMapper.toDTO(entity);
    }
}