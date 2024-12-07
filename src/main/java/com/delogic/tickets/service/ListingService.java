package com.delogic.tickets.service;

import com.delogic.tickets.domain.Listing;
import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.mapper.ListingMapper;
import com.delogic.tickets.repository.ListingRepository;
import com.delogic.tickets.util.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingService extends BaseService<Listing, ListingDTO> {

    private final ListingMapper listingMapper;

    private final ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository, ListingMapper listingMapper) {
        super(listingRepository);
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    @Override
    protected ListingDTO toDTO(Listing listing) {
        return listingMapper.toDTO(listing);
    }

    public List<?> getPromotionalListings(LocalDateTime contextDate, Long categoryId, String city, boolean includeUrls) {
        var listings = this.listingRepository.findUnsoldListings(contextDate, categoryId, city);
        if (includeUrls) {
            return listings.stream()
                    .map(UrlBuilder::buildUrl)
                    .map(url -> url.replaceFirst("/promotional", ""))
                    .collect(Collectors.toList());
        } else {
            return listings;
        }
    }
}