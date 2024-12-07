package com.delogic.tickets.service;

import com.delogic.tickets.domain.Category;
import com.delogic.tickets.dto.CategoryDTO;
import com.delogic.tickets.mapper.CategoryMapper;
import com.delogic.tickets.repository.CategoryRepository;
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

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_Success() {
        Category category = new Category();
        CategoryDTO categoryDTO = CategoryDTO.builder().build();
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

        Optional<CategoryDTO> result = categoryService.getById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(categoryDTO);
    }

    @Test
    public void testGetById_NotFound() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<CategoryDTO> result = categoryService.getById(1L);

        assertThat(result).isNotPresent();
    }

    @Test
    public void testGetAllIdsOrUrls_Ids() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(categoryRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = categoryService.getAllIdsOrUrls(0, 10, false);

        assertThat(result).isEqualTo(ids);
    }

    @Test
    public void testGetAllIdsOrUrls_Urls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/categories");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Long> ids = List.of(1L, 2L, 3L);
        List<String> urls = ids.stream().map(id -> "http://localhost/api/categories/" + id).collect(Collectors.toList());
        when(categoryRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = categoryService.getAllIdsOrUrls(0, 10, true);

        assertThat(result).isEqualTo(urls);
        RequestContextHolder.resetRequestAttributes();
    }
}