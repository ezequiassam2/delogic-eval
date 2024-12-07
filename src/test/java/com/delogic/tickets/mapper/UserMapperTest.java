package com.delogic.tickets.mapper;

import com.delogic.tickets.domain.User;
import com.delogic.tickets.dto.UserDTO;
import com.delogic.tickets.mapper.impl.UserMapperImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    public void testToDTO() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");

        UserDTO userDTO = userMapper.toDTO(user);

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getId()).isEqualTo(user.getId());
        assertThat(userDTO.getUsername()).isEqualTo(user.getUsername());
        assertThat(userDTO.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testToDTO_NullUser() {
        UserDTO userDTO = userMapper.toDTO(null);
        assertThat(userDTO).isNull();
    }
}