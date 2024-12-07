package com.delogic.tickets.controller;

import com.delogic.tickets.dto.CategoryDTO;
import com.delogic.tickets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<?>> getAllCategoryIds(@RequestParam(defaultValue = "${default.page}") int page,
                                                     @RequestParam(defaultValue = "${default.size}") int size,
                                                     @RequestParam(defaultValue = "false") boolean includeUrls) {
        List<?> categories = categoryService.getAllIdsOrUrls(page, size, includeUrls);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}