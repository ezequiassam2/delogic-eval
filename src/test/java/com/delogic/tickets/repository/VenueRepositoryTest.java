package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Venue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VenueRepositoryTest {

    @Autowired
    private VenueRepository venueRepository;

    @Test
    public void testSaveAndFindVenue() {
        Venue venue = new Venue();
        venue.setName("Test Venue");
        venueRepository.save(venue);

        Optional<Venue> foundVenue = venueRepository.findById(venue.getId());
        assertThat(foundVenue).isPresent();
        assertThat(foundVenue.get().getName()).isEqualTo("Test Venue");
    }
}