package com.delogic.tickets.controller;

import com.delogic.tickets.dto.EventDTO;
import com.delogic.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController extends BaseController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<?>> getAllEventIds(@RequestParam(defaultValue = "${default.page}") int page, @RequestParam(defaultValue = "${default.size}") int size, @RequestParam(defaultValue = "false") boolean includeUrls) {
        List<?> events = eventService.getAllIdsOrUrls(page, size, includeUrls);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return eventService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}