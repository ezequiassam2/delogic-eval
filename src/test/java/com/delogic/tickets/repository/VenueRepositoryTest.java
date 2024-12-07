package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Venue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void testFindAllIds() {
        Venue venue1 = new Venue();
        venue1.setName("Venue 1");
        venueRepository.save(venue1);

        Venue venue2 = new Venue();
        venue2.setName("Venue 2");
        venueRepository.save(venue2);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Long> idsPage = venueRepository.findAllIds(pageable);

        assertThat(idsPage).isNotNull();
        assertThat(idsPage.getContent()).containsExactlyInAnyOrder(venue1.getId(), venue2.getId());
    }
}