package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dates")
@Data
public class Date {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_id")
    private Long id;

    private java.sql.Date calendarDate;
    private String day;
    private Integer week;
    private String month;
    private Integer quarter;
    private Integer year;
    private Boolean holidayFlag;
}