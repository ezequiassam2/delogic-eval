package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DateRepositoryTest {

    @Autowired
    private DateRepository dateRepository;

    @Test
    public void testSaveAndFindDate() {
        Date date = new Date();
        date.setCalendarDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
        dateRepository.save(date);

        Optional<Date> foundDate = dateRepository.findById(date.getId());
        assertThat(foundDate).isPresent();
        assertThat(foundDate.get().getCalendarDate()).isEqualTo(date.getCalendarDate());
    }

    @Test
    public void testFindAllIds() {
        Date date1 = new Date();
        date1.setCalendarDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
        dateRepository.save(date1);

        Date date2 = new Date();
        date2.setCalendarDate(java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(1)));
        dateRepository.save(date2);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Long> idsPage = dateRepository.findAllIds(pageable);

        assertThat(idsPage).isNotNull();
        assertThat(idsPage.getContent()).containsExactlyInAnyOrder(date1.getId(), date2.getId());
    }
}