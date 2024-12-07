package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.Category;
import com.delogic.tickets.dto.CategoryDTO;
import com.delogic.tickets.mapper.CategoryMapper;

public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .group(category.getGroup())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}