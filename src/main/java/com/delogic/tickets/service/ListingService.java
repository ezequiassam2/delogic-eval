package com.delogic.tickets.service;

import com.delogic.tickets.domain.Listing;
import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.mapper.ListingMapper;
import com.delogic.tickets.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService extends BaseService<Listing, ListingDTO> {

    private final ListingMapper listingMapper;

    @Autowired
    public ListingService(ListingRepository listingRepository, ListingMapper listingMapper) {
        super(listingRepository);
        this.listingMapper = listingMapper;
    }

    @Override
    protected ListingDTO toDTO(Listing listing) {
        return listingMapper.toDTO(listing);
    }
}