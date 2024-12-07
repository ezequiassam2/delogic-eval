package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Date;
import com.delogic.tickets.dto.DateDTO;
import com.delogic.tickets.mapper.impl.DateMapperImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DateMapperTest {

    private final DateMapper dateMapper = new DateMapperImpl();

    @Test
    public void testToDTO() {
        Date date = new Date();
        date.setId(1L);
        date.setCalendarDate(java.sql.Date.valueOf("2023-10-10"));
        date.setDay("WE");
        date.setWeek(41);
        date.setMonth("JAN");
        date.setQuarter(4);
        date.setYear(2023);
        date.setHolidayFlag(true);

        DateDTO dateDTO = dateMapper.toDTO(date);

        assertThat(dateDTO).isNotNull();
        assertThat(dateDTO.getId()).isEqualTo(date.getId());
        assertThat(dateDTO.getCalendarDate()).isEqualTo(date.getCalendarDate().toLocalDate());
        assertThat(dateDTO.getDay()).isEqualTo(date.getDay());
        assertThat(dateDTO.getWeek()).isEqualTo(date.getWeek());
        assertThat(dateDTO.getMonth()).isEqualTo(date.getMonth());
        assertThat(dateDTO.getQuarter()).isEqualTo(date.getQuarter());
        assertThat(dateDTO.getYear()).isEqualTo(date.getYear());
        assertThat(dateDTO.getHolidayFlag()).isEqualTo(date.getHolidayFlag());
    }

    @Test
    public void testToDTO_NullDate() {
        DateDTO dateDTO = dateMapper.toDTO(null);
        assertThat(dateDTO).isNull();
    }
}
