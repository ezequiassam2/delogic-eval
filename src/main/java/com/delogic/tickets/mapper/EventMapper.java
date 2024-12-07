package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Event;
import com.delogic.tickets.dto.EventDTO;

public interface EventMapper {
    EventDTO toDTO(Event event);
}