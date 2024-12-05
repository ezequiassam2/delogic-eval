package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Listing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ListingRepositoryTest {

    @Autowired
    private ListingRepository listingRepository;

    @Test
    public void testSaveAndFindListing() {
        Listing listing = new Listing();
        listing.setTotalPrice(BigDecimal.valueOf(100));
        listingRepository.save(listing);

        Optional<Listing> foundListing = listingRepository.findById(listing.getId());
        assertThat(foundListing).isPresent();
        assertThat(foundListing.get().getTotalPrice()).isEqualTo(BigDecimal.valueOf(100));
    }
}