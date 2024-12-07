package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void testFindAllIds() {
        Category category1 = new Category();
        category1.setName("Category 1");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setName("Category 2");
        categoryRepository.save(category2);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Long> idsPage = categoryRepository.findAllIds(pageable);

        assertThat(idsPage).isNotNull();
        assertThat(idsPage.getContent()).containsExactlyInAnyOrder(category1.getCategoryId(), category2.getCategoryId());
    }
}