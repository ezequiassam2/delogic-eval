package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDTO {
    private Long id;
    private String name;
    private java.sql.Timestamp startTime;
    private VenueDTO venue;
    private CategoryDTO category;
    private DateDTO date;
}