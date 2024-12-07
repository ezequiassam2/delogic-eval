package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
public class SaleDTO {
    private Long id;
    private Integer quantitySold;
    private BigDecimal pricePaid;
    private BigDecimal commissionAmount;
    private java.time.LocalDateTime timestamp;
    private ListingDTO listing;
    private UserDTO seller;
    private UserDTO buyer;
    private EventDTO event;
    private DateDTO date;
}