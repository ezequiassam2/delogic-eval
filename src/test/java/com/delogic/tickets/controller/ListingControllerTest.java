package com.delogic.tickets.controller;

import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.service.ListingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ListingControllerTest {

    @Mock
    private ListingService listingService;

    @InjectMocks
    private ListingController listingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllListingIds_Success() {
        List listingList = Collections.singletonList(1L);
        when(listingService.getAllIdsOrUrls(0, 10, false)).thenReturn(listingList);

        ResponseEntity<List<?>> response = listingController.getAllListingIds(0, 10, false);

        assertEquals(ResponseEntity.ok(listingList), response);
    }

    @Test
    public void testGetListingById_Success() {
        ListingDTO listingDTO = ListingDTO.builder().build();
        when(listingService.getById(1L)).thenReturn(Optional.of(listingDTO));

        ResponseEntity<ListingDTO> response = listingController.getListingById(1L);

        assertEquals(ResponseEntity.ok(listingDTO), response);
    }

    @Test
    public void testGetListingById_NotFound() {
        when(listingService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<ListingDTO> response = listingController.getListingById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }

    @Test
    public void testGetPromotionalListings_Success() {
        var contextDate = LocalDateTime.of(2023, 10, 10, 20, 0, 0);
        List listingIds = Collections.singletonList(1L);
        when(listingService.getPromotionalListings(contextDate, null, null, false)).thenReturn(listingIds);

        ResponseEntity<List<?>> response = listingController.getPromotionalListings(contextDate, null, null, false);

        assertEquals(ResponseEntity.ok(listingIds), response);
    }

    @Test
    public void testGetPromotionalListings_WithCategoryAndCity() {
        var contextDate = LocalDateTime.of(2023, 10, 10, 20, 0, 0);
        var categoryId = 1L;
        var city = "New York";
        List listingIds = Collections.singletonList(1L);
        when(listingService.getPromotionalListings(contextDate, categoryId, city, false)).thenReturn(listingIds);

        ResponseEntity<List<?>> response = listingController.getPromotionalListings(contextDate, categoryId, city, false);

        assertEquals(ResponseEntity.ok(listingIds), response);
    }

    @Test
    public void testGetPromotionalListings_IncludeUrls() {
        var contextDate = LocalDateTime.of(2023, 10, 10, 20, 0, 0);
        List listingUrls = Collections.singletonList("http://localhost/api/listings/1");
        when(listingService.getPromotionalListings(contextDate, null, null, true)).thenReturn(listingUrls);

        ResponseEntity<List<?>> response = listingController.getPromotionalListings(contextDate, null, null, true);

        assertEquals(ResponseEntity.ok(listingUrls), response);
    }
}