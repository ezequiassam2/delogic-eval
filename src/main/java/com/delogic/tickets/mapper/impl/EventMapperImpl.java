package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.Event;
import com.delogic.tickets.dto.EventDTO;
import com.delogic.tickets.mapper.CategoryMapper;
import com.delogic.tickets.mapper.DateMapper;
import com.delogic.tickets.mapper.EventMapper;
import com.delogic.tickets.mapper.VenueMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EventMapperImpl implements EventMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DateMapper dateMapper;

    @Autowired
    private VenueMapper venueMapper;

    @Override
    public EventDTO toDTO(Event event) {
        if (event == null) {
            return null;
        }
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime().toLocalDateTime())
                .venue(venueMapper.toDTO(event.getVenue()))
                .category(categoryMapper.toDTO(event.getCategory()))
                .date(dateMapper.toDTO(event.getDate()))
                .build();
    }
}