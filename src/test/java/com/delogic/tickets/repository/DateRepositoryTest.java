package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
}