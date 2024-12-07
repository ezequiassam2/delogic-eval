package com.delogic.tickets.controller;

import com.delogic.tickets.dto.VenueDTO;
import com.delogic.tickets.service.VenueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VenueControllerTest {

    @Mock
    private VenueService venueService;

    @InjectMocks
    private VenueController venueController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllVenueIds_Success() {
        List venueList = Collections.singletonList(1L);
        when(venueService.getAllIdsOrUrls(0, 10, false)).thenReturn(venueList);

        ResponseEntity<List<?>> response = venueController.getAllVenueIds(0, 10, false);

        assertEquals(ResponseEntity.ok(venueList), response);
    }

    @Test
    public void testGetVenueById_Success() {
        VenueDTO venueDTO = VenueDTO.builder().build();
        when(venueService.getById(1L)).thenReturn(Optional.of(venueDTO));

        ResponseEntity<VenueDTO> response = venueController.getVenueById(1L);

        assertEquals(ResponseEntity.ok(venueDTO), response);
    }

    @Test
    public void testGetVenueById_NotFound() {
        when(venueService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<VenueDTO> response = venueController.getVenueById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}