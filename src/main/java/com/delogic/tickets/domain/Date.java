package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dates")
@Data
public class Date {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_id")
    private Long id;
    private java.sql.Date calendarDate;

    @Column(name = "`day`")
    private String day;

    @Column(name = "`week`")
    private Integer week;

    @Column(name = "`month`")
    private String month;

    @Column(name = "`quarter`")
    private Integer quarter;

    @Column(name = "`year`")
    private Integer year;
    private Boolean holidayFlag;
}