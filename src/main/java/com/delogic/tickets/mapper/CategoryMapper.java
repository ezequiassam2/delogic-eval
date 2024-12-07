package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Category;
import com.delogic.tickets.dto.CategoryDTO;

public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
}