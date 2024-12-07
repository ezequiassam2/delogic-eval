package com.delogic.tickets.controller;

import com.delogic.tickets.dto.DateDTO;
import com.delogic.tickets.service.DateService;
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

public class DateControllerTest {

    @Mock
    private DateService dateService;

    @InjectMocks
    private DateController dateController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDateIds_Success() {
        List dateList = Collections.singletonList(1L);
        when(dateService.getAllIdsOrUrls(0, 10, false)).thenReturn(dateList);

        ResponseEntity<List<?>> response = dateController.getAllDateIds(0, 10, false);

        assertEquals(ResponseEntity.ok(dateList), response);
    }

    @Test
    public void testGetDateById_Success() {
        DateDTO dateDTO = DateDTO.builder().build();
        when(dateService.getById(1L)).thenReturn(Optional.of(dateDTO));

        ResponseEntity<DateDTO> response = dateController.getDateById(1L);

        assertEquals(ResponseEntity.ok(dateDTO), response);
    }

    @Test
    public void testGetDateById_NotFound() {
        when(dateService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<DateDTO> response = dateController.getDateById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}