package com.delogic.tickets.service;

import com.delogic.tickets.domain.Date;
import com.delogic.tickets.dto.DateDTO;
import com.delogic.tickets.mapper.DateMapper;
import com.delogic.tickets.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateService extends BaseService<Date, DateDTO> {

    private final DateMapper dateMapper;

    @Autowired
    public DateService(DateRepository repository, DateMapper dateMapper) {
        super(repository);
        this.dateMapper = dateMapper;
    }

    @Override
    protected DateDTO toDTO(Date entity) {
        return dateMapper.toDTO(entity);
    }
}