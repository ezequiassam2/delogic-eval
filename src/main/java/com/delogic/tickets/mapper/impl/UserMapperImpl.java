package com.delogic.tickets.mapper.impl;

import com.delogic.tickets.domain.User;
import com.delogic.tickets.dto.UserDTO;
import com.delogic.tickets.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .city(user.getCity())
                .state(user.getState())
                .email(user.getEmail())
                .phone(user.getPhone())
                .sports(user.getSports())
                .theatre(user.getTheatre())
                .concerts(user.getConcerts())
                .jazz(user.getJazz())
                .classical(user.getClassical())
                .opera(user.getOpera())
                .rock(user.getRock())
                .vegas(user.getVegas())
                .broadway(user.getBroadway())
                .musicals(user.getMusicals())
                .build();
    }

}
