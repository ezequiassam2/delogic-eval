package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Category;
import com.delogic.tickets.dto.CategoryDTO;
import com.delogic.tickets.mapper.impl.CategoryMapperImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryMapperTest {

    private final CategoryMapper categoryMapper = new CategoryMapperImpl();

    @Test
    public void testToDTO() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setGroup("Music");
        category.setName("Concert");
        category.setDescription("Live music concert");

        CategoryDTO categoryDTO = categoryMapper.toDTO(category);

        assertThat(categoryDTO).isNotNull();
        assertThat(categoryDTO.getCategoryId()).isEqualTo(category.getCategoryId());
        assertThat(categoryDTO.getGroup()).isEqualTo(category.getGroup());
        assertThat(categoryDTO.getName()).isEqualTo(category.getName());
        assertThat(categoryDTO.getDescription()).isEqualTo(category.getDescription());
    }

    @Test
    public void testToDTO_NullCategory() {
        CategoryDTO categoryDTO = categoryMapper.toDTO(null);
        assertThat(categoryDTO).isNull();
    }
}