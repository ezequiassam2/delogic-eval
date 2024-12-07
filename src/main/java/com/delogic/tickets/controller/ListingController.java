package com.delogic.tickets.controller;

import com.delogic.tickets.dto.ListingDTO;
import com.delogic.tickets.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ListingController extends BaseController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/listings")
    public ResponseEntity<List<?>> getAllListingIds(@RequestParam(defaultValue = "${default.page}") int page, @RequestParam(defaultValue = "${default.size}") int size, @RequestParam(defaultValue = "false") boolean includeUrls) {
        List<?> listings = listingService.getAllIdsOrUrls(page, size, includeUrls);
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/listings/{id}")
    public ResponseEntity<ListingDTO> getListingById(@PathVariable Long id) {
        return listingService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listings/promotional")
    public ResponseEntity<List<?>> getPromotionalListings(
            @RequestParam("contextDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime contextDate,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(defaultValue = "false") boolean includeUrls) {

        List<?> listingIds = listingService.getPromotionalListings(contextDate, categoryId, city, includeUrls);
        return ResponseEntity.ok(listingIds);
    }
}