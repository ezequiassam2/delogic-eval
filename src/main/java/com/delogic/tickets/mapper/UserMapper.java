package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.User;
import com.delogic.tickets.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}