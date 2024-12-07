package com.delogic.tickets.service;

import com.delogic.tickets.domain.User;
import com.delogic.tickets.dto.UserDTO;
import com.delogic.tickets.mapper.UserMapper;
import com.delogic.tickets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDTO> {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository repository, UserMapper userMapper) {
        super(repository);
        this.userMapper = userMapper;
    }

    @Override
    protected UserDTO toDTO(User entity) {
        return this.userMapper.toDTO(entity);
    }
}