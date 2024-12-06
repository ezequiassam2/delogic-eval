package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sales")
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Listing listing;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private Date date;

    private Integer quantitySold;
    private java.math.BigDecimal pricePaid;
    private java.math.BigDecimal commissionAmount;
    @Column(name = "sale_timestamp")
    private java.sql.Timestamp timestamp;
}
