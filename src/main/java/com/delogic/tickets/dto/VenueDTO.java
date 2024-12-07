package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenueDTO {
    private Long id;
    private String name;
    private String city;
    private String state;
    private Integer seatingCapacity;
}