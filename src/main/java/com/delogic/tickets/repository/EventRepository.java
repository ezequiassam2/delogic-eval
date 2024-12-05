package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
