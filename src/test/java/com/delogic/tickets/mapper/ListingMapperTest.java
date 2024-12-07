package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Listing;
import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.mapper.impl.ListingMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class ListingMapperTest {

    @InjectMocks
    private final ListingMapper listingMapper = new ListingMapperImpl();
    @Mock
    private UserMapper userMapper;
    @Mock
    private EventMapper eventMapper;
    @Mock
    private DateMapper dateMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testToDTO() {
        Listing listing = new Listing();
        listing.setId(1L);
        listing.setNumberOfTickets(2);
        listing.setPricePerTicket(java.math.BigDecimal.valueOf(50.00));
        listing.setTotalPrice(java.math.BigDecimal.valueOf(100.00));
        listing.setTimestamp(java.sql.Timestamp.valueOf("2023-10-10 20:00:00"));

        ListingDTO listingDTO = listingMapper.toDTO(listing);

        assertThat(listingDTO).isNotNull();
        assertThat(listingDTO.getId()).isEqualTo(listing.getId());
        assertThat(listingDTO.getNumberOfTickets()).isEqualTo(listing.getNumberOfTickets());
        assertThat(listingDTO.getPricePerTicket()).isEqualTo(listing.getPricePerTicket());
        assertThat(listingDTO.getTotalPrice()).isEqualTo(listing.getTotalPrice());
        assertThat(listingDTO.getTimestamp()).isEqualTo(listing.getTimestamp().toLocalDateTime());
    }

    @Test
    public void testToDTO_NullListing() {
        ListingDTO listingDTO = listingMapper.toDTO(null);
        assertThat(listingDTO).isNull();
    }
}