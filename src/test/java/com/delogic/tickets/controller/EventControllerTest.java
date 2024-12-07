package com.delogic.tickets.controller;

import com.delogic.tickets.dto.EventDTO;
import com.delogic.tickets.service.EventService;
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

public class EventControllerTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventController eventController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEventIds_Success() {
        List eventList = Collections.singletonList(1L);
        when(eventService.getAllIdsOrUrls(0, 10, false)).thenReturn(eventList);

        ResponseEntity<List<?>> response = eventController.getAllEventIds(0, 10, false);

        assertEquals(ResponseEntity.ok(eventList), response);
    }

    @Test
    public void testGetEventById_Success() {
        EventDTO eventDTO = EventDTO.builder().build();
        when(eventService.getById(1L)).thenReturn(Optional.of(eventDTO));

        ResponseEntity<EventDTO> response = eventController.getEventById(1L);

        assertEquals(ResponseEntity.ok(eventDTO), response);
    }

    @Test
    public void testGetEventById_NotFound() {
        when(eventService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<EventDTO> response = eventController.getEventById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}