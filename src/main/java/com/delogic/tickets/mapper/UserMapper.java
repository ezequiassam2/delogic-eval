package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.User;
import com.delogic.tickets.dto.UserDTO;

public interface UserMapper {
    UserDTO toDTO(User user);
}