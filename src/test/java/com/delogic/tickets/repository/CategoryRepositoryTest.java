package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveAndFindCategory() {
        Category category = new Category();
        category.setName("Test Category");
        categoryRepository.save(category);

        Optional<Category> foundCategory = categoryRepository.findById(category.getCategoryId());
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo("Test Category");
    }
}