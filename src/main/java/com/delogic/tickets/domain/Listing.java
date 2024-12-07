package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "listings")
@Data
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listing_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private Date date;

    private Integer numberOfTickets;
    private java.math.BigDecimal pricePerTicket;
    private java.math.BigDecimal totalPrice;
    @Column(name = "listing_timestamp")
    private java.sql.Timestamp timestamp;
}
