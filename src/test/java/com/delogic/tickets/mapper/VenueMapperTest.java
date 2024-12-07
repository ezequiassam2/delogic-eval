package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Venue;
import com.delogic.tickets.dto.VenueDTO;
import com.delogic.tickets.mapper.impl.VenueMapperImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VenueMapperTest {

    private final VenueMapper venueMapper = new VenueMapperImpl();

    @Test
    public void testToDTO() {
        Venue venue = new Venue();
        venue.setId(1L);
        venue.setName("Test Venue");
        venue.setCity("Test City");
        venue.setState("Test State");
        venue.setSeatingCapacity(10000);

        VenueDTO venueDTO = venueMapper.toDTO(venue);

        assertThat(venueDTO).isNotNull();
        assertThat(venueDTO.getId()).isEqualTo(venue.getId());
        assertThat(venueDTO.getName()).isEqualTo(venue.getName());
        assertThat(venueDTO.getCity()).isEqualTo(venue.getCity());
        assertThat(venueDTO.getState()).isEqualTo(venue.getState());
        assertThat(venueDTO.getSeatingCapacity()).isEqualTo(venue.getSeatingCapacity());
    }

    @Test
    public void testToDTO_NullVenue() {
        VenueDTO venueDTO = venueMapper.toDTO(null);
        assertThat(venueDTO).isNull();
    }
}