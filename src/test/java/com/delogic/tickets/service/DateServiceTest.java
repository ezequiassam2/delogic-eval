package com.delogic.tickets.service;

import com.delogic.tickets.domain.Date;
import com.delogic.tickets.dto.DateDTO;
import com.delogic.tickets.mapper.DateMapper;
import com.delogic.tickets.repository.DateRepository;
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

public class DateServiceTest {

    @Mock
    private DateRepository dateRepository;

    @Mock
    private DateMapper dateMapper;

    @InjectMocks
    private DateService dateService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_Success() {
        Date date = new Date();
        DateDTO dateDTO = DateDTO.builder().build();
        when(dateRepository.findById(1L)).thenReturn(Optional.of(date));
        when(dateMapper.toDTO(date)).thenReturn(dateDTO);

        Optional<DateDTO> result = dateService.getById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(dateDTO);
    }

    @Test
    public void testGetById_NotFound() {
        when(dateRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<DateDTO> result = dateService.getById(1L);

        assertThat(result).isNotPresent();
    }

    @Test
    public void testGetAllIdsOrUrls_Ids() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(dateRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = dateService.getAllIdsOrUrls(0, 10, false);

        assertThat(result).isEqualTo(ids);
    }

    @Test
    public void testGetAllIdsOrUrls_Urls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/dates");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Long> ids = List.of(1L, 2L, 3L);
        List<String> urls = ids.stream().map(id -> "http://localhost/api/dates/" + id).collect(Collectors.toList());
        when(dateRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = dateService.getAllIdsOrUrls(0, 10, true);

        assertThat(result).isEqualTo(urls);

        RequestContextHolder.resetRequestAttributes();
    }
}