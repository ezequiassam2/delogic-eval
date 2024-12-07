package com.delogic.tickets.controller;

import com.delogic.tickets.dto.SaleDTO;
import com.delogic.tickets.service.SaleService;
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

public class SaleControllerTest {

    @Mock
    private SaleService saleService;

    @InjectMocks
    private SaleController saleController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSaleIds_Success() {
        List saleList = Collections.singletonList(1L);
        when(saleService.getAllIdsOrUrls(0, 10, false)).thenReturn(saleList);

        ResponseEntity<List<?>> response = saleController.getAllSaleIds(0, 10, false);

        assertEquals(ResponseEntity.ok(saleList), response);
    }

    @Test
    public void testGetSaleById_Success() {
        SaleDTO saleDTO = SaleDTO.builder().build();
        when(saleService.getById(1L)).thenReturn(Optional.of(saleDTO));

        ResponseEntity<SaleDTO> response = saleController.getSaleById(1L);

        assertEquals(ResponseEntity.ok(saleDTO), response);
    }

    @Test
    public void testGetSaleById_NotFound() {
        when(saleService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<SaleDTO> response = saleController.getSaleById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}