package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "venues")
@Data
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venue_id")
    private Long id;

    @Column(name = "venue_name")
    private String name;
    private String city;
    private String state;
    private Integer seatingCapacity;
}