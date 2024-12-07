package com.delogic.tickets.service;

import com.delogic.tickets.domain.Event;
import com.delogic.tickets.dto.EventDTO;
import com.delogic.tickets.mapper.EventMapper;
import com.delogic.tickets.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseService<Event, EventDTO> {

    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        super(eventRepository);
        this.eventMapper = eventMapper;
    }

    @Override
    protected EventDTO toDTO(Event entity) {
        return this.eventMapper.toDTO(entity);
    }
}