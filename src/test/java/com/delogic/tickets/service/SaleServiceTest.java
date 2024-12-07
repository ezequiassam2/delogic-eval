package com.delogic.tickets.service;

import com.delogic.tickets.domain.Sale;
import com.delogic.tickets.dto.SaleDTO;
import com.delogic.tickets.mapper.SaleMapper;
import com.delogic.tickets.repository.SaleRepository;
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

public class SaleServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private SaleMapper saleMapper;

    @InjectMocks
    private SaleService saleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_Success() {
        Sale sale = new Sale();
        SaleDTO saleDTO = SaleDTO.builder().build();
        when(saleRepository.findById(1L)).thenReturn(Optional.of(sale));
        when(saleMapper.toDTO(sale)).thenReturn(saleDTO);

        Optional<SaleDTO> result = saleService.getById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(saleDTO);
    }

    @Test
    public void testGetById_NotFound() {
        when(saleRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<SaleDTO> result = saleService.getById(1L);

        assertThat(result).isNotPresent();
    }

    @Test
    public void testGetAllIdsOrUrls_Ids() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(saleRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = saleService.getAllIdsOrUrls(0, 10, false);

        assertThat(result).isEqualTo(ids);
    }

    @Test
    public void testGetAllIdsOrUrls_Urls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/sales");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Long> ids = List.of(1L, 2L, 3L);
        List<String> urls = ids.stream().map(id -> "http://localhost/api/sales/" + id).collect(Collectors.toList());
        when(saleRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = saleService.getAllIdsOrUrls(0, 10, true);

        assertThat(result).isEqualTo(urls);
        RequestContextHolder.resetRequestAttributes();
    }
}