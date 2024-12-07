package com.delogic.tickets.service;

import com.delogic.tickets.domain.Venue;
import com.delogic.tickets.dto.VenueDTO;
import com.delogic.tickets.mapper.VenueMapper;
import com.delogic.tickets.repository.VenueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class VenueServiceTest {

    @Mock
    private VenueRepository venueRepository;

    @Mock
    private VenueMapper venueMapper;

    @InjectMocks
    private VenueService venueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_Success() {
        Venue venue = new Venue();
        VenueDTO venueDTO = VenueDTO.builder().build();
        when(venueRepository.findById(1L)).thenReturn(Optional.of(venue));
        when(venueMapper.toDTO(venue)).thenReturn(venueDTO);

        Optional<VenueDTO> result = venueService.getById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(venueDTO);
    }

    @Test
    public void testGetById_NotFound() {
        when(venueRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<VenueDTO> result = venueService.getById(1L);

        assertThat(result).isNotPresent();
    }

    @Test
    public void testGetAllIdsOrUrls_Ids() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(venueRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = venueService.getAllIdsOrUrls(0, 10, false);

        assertThat(result).isEqualTo(ids);
    }

    @Test
    public void testGetAllIdsOrUrls_Urls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/venues");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Long> ids = List.of(1L, 2L, 3L);
        List<String> urls = ids.stream().map(id -> "http://localhost/api/venues/" + id).collect(Collectors.toList());
        when(venueRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = venueService.getAllIdsOrUrls(0, 10, true);

        assertThat(result).isEqualTo(urls);
        RequestContextHolder.resetRequestAttributes();
    }
}