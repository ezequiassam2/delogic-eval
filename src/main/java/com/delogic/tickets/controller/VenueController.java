package com.delogic.tickets.controller;

import com.delogic.tickets.dto.VenueDTO;
import com.delogic.tickets.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenueController extends BaseController {

    @Autowired
    private VenueService venueService;

    @GetMapping("/venues")
    public ResponseEntity<List<?>> getAllVenueIds(@RequestParam(defaultValue = "${default.page}") int page, @RequestParam(defaultValue = "${default.size}") int size, @RequestParam(defaultValue = "false") boolean includeUrls) {
        List<?> venues = venueService.getAllIdsOrUrls(page, size, includeUrls);
        return ResponseEntity.ok(venues);
    }

    @GetMapping("/venues/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Long id) {
        return venueService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}