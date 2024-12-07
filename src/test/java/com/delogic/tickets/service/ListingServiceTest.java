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

import java.time.LocalDateTime;
import java.util.Collections;
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

    @Test
    public void testGetPromotionalListings_Success() {
        LocalDateTime contextDate = LocalDateTime.of(2023, 10, 10, 20, 0, 0);
        List<Long> listingIds = Collections.singletonList(1L);
        when(listingRepository.findUnsoldListings(contextDate, null, null)).thenReturn(listingIds);

        List<?> result = listingService.getPromotionalListings(contextDate, null, null, false);

        assertThat(result).isEqualTo(listingIds);
    }

    @Test
    public void testGetPromotionalListings_WithCategoryAndCity() {
        LocalDateTime contextDate = LocalDateTime.of(2023, 10, 10, 20, 0, 0);
        Long categoryId = 1L;
        String city = "New York";
        List<Long> listingIds = Collections.singletonList(1L);
        when(listingRepository.findUnsoldListings(contextDate, categoryId, city)).thenReturn(listingIds);

        List<?> result = listingService.getPromotionalListings(contextDate, categoryId, city, false);

        assertThat(result).isEqualTo(listingIds);
    }

    @Test
    public void testGetPromotionalListings_IncludeUrls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/listings");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        LocalDateTime contextDate = LocalDateTime.of(2023, 10, 10, 20, 0, 0);
        List<Long> listingIds = Collections.singletonList(1L);
        when(listingRepository.findUnsoldListings(contextDate, null, null)).thenReturn(listingIds);

        List<?> result = listingService.getPromotionalListings(contextDate, null, null, true);

        assertThat(result).isEqualTo(listingIds.stream().map(id -> "http://localhost/api/listings/" + id).collect(Collectors.toList()));
        RequestContextHolder.resetRequestAttributes();
    }
}