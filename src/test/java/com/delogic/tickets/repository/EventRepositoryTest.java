package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void testSaveAndFindEvent() {
        Event event = new Event();
        event.setName("Test Event");
        eventRepository.save(event);

        Optional<Event> foundEvent = eventRepository.findById(event.getId());
        assertThat(foundEvent).isPresent();
        assertThat(foundEvent.get().getName()).isEqualTo("Test Event");
    }
}