package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ListingDTO {
    private Long id;
    private Integer numberOfTickets;
    private BigDecimal pricePerTicket;
    private BigDecimal totalPrice;
    private java.time.LocalDateTime timestamp;
    private UserDTO seller;
    private EventDTO event;
    private DateDTO date;
}