package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.Date;
import com.delogic.tickets.dto.DateDTO;

public interface DateMapper {
    DateDTO toDTO(Date date);
}