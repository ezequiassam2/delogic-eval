package com.delogic.tickets.controller;

import com.delogic.tickets.dto.DateDTO;
import com.delogic.tickets.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DateController extends BaseController {

    @Autowired
    private DateService dateService;

    @GetMapping("/dates")
    public ResponseEntity<List<?>> getAllDateIds(@RequestParam(defaultValue = "${default.page}") int page, @RequestParam(defaultValue = "${default.size}") int size, @RequestParam(defaultValue = "false") boolean includeUrls) {
        List<?> dates = dateService.getAllIdsOrUrls(page, size, includeUrls);
        return ResponseEntity.ok(dates);
    }

    @GetMapping("/dates/{id}")
    public ResponseEntity<DateDTO> getDateById(@PathVariable Long id) {
        return dateService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}