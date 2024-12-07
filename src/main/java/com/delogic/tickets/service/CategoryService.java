package com.delogic.tickets.service;

import com.delogic.tickets.domain.Category;
import com.delogic.tickets.dto.CategoryDTO;
import com.delogic.tickets.mapper.CategoryMapper;
import com.delogic.tickets.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, CategoryDTO> {

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        super(categoryRepository);
        this.categoryMapper = categoryMapper;
    }

    @Override
    protected CategoryDTO toDTO(Category entity) {
        return this.categoryMapper.toDTO(entity);
    }
}