package com.delogic.tickets.controller;

import com.delogic.tickets.dto.CategoryDTO;
import com.delogic.tickets.service.CategoryService;
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

public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCategoryIds_Success() {
        List categoryList = Collections.singletonList(1L);
        when(categoryService.getAllIdsOrUrls(0, 10, false)).thenReturn(categoryList);

        ResponseEntity<List<?>> response = categoryController.getAllCategoryIds(0, 10, false);

        assertEquals(ResponseEntity.ok(categoryList), response);
    }

    @Test
    public void testGetCategoryById_Success() {
        CategoryDTO categoryDTO = CategoryDTO.builder().build();
        when(categoryService.getById(1L)).thenReturn(Optional.of(categoryDTO));

        ResponseEntity<CategoryDTO> response = categoryController.getCategoryById(1L);

        assertEquals(ResponseEntity.ok(categoryDTO), response);
    }

    @Test
    public void testGetCategoryById_NotFound() {
        when(categoryService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<CategoryDTO> response = categoryController.getCategoryById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}