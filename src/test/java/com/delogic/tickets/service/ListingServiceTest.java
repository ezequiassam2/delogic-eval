package com.delogic.tickets.service;

import com.delogic.tickets.domain.Listing;
import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.mapper.ListingMapper;
import com.delogic.tickets.repository.ListingRepository;
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

public class ListingServiceTest {

    @Mock
    private ListingRepository listingRepository;

    @Mock
    private ListingMapper listingMapper;

    @InjectMocks
    private ListingService listingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_Success() {
        Listing listing = new Listing();
        ListingDTO listingDTO = ListingDTO.builder().build();
        when(listingRepository.findById(1L)).thenReturn(Optional.of(listing));
        when(listingMapper.toDTO(listing)).thenReturn(listingDTO);

        Optional<ListingDTO> result = listingService.getById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(listingDTO);
    }

    @Test
    public void testGetById_NotFound() {
        when(listingRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<ListingDTO> result = listingService.getById(1L);

        assertThat(result).isNotPresent();
    }

    @Test
    public void testGetAllIdsOrUrls_Ids() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(listingRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = listingService.getAllIdsOrUrls(0, 10, false);

        assertThat(result).isEqualTo(ids);
    }

    @Test
    public void testGetAllIdsOrUrls_Urls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/listings");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Long> ids = List.of(1L, 2L, 3L);
        List<String> urls = ids.stream().map(id -> "http://localhost/api/listings/" + id).collect(Collectors.toList());
        when(listingRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = listingService.getAllIdsOrUrls(0, 10, true);

        assertThat(result).isEqualTo(urls);
        RequestContextHolder.resetRequestAttributes();
    }
}