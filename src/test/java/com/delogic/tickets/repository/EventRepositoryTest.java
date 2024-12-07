package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void testFindAllIds() {
        Event event1 = new Event();
        event1.setName("Event 1");
        eventRepository.save(event1);

        Event event2 = new Event();
        event2.setName("Event 2");
        eventRepository.save(event2);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Long> idsPage = eventRepository.findAllIds(pageable);

        assertThat(idsPage).isNotNull();
        assertThat(idsPage.getContent()).containsExactlyInAnyOrder(event1.getId(), event2.getId());
    }
}