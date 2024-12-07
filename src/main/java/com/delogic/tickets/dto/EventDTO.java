package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDTO {
    private Long id;
    private String name;
    private java.time.LocalDateTime startTime;
    private VenueDTO venue;
    private CategoryDTO category;
    private DateDTO date;
}