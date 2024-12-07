package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.Date;
import com.delogic.tickets.dto.DateDTO;
import com.delogic.tickets.mapper.DateMapper;

public class DateMapperImpl implements DateMapper {

    @Override
    public DateDTO toDTO(Date date) {
        if (date == null) {
            return null;
        }
        return DateDTO.builder()
                .id(date.getId())
                .calendarDate(date.getCalendarDate().toLocalDate())
                .day(date.getDay())
                .week(date.getWeek())
                .month(date.getMonth())
                .quarter(date.getQuarter())
                .year(date.getYear())
                .holidayFlag(date.getHolidayFlag())
                .build();
    }
}