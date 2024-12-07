package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DateDTO {
    private Long id;
    private java.time.LocalDate calendarDate;
    private String day;
    private Integer week;
    private String month;
    private Integer quarter;
    private Integer year;
    private Boolean holidayFlag;
}