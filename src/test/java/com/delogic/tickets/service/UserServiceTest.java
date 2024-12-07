package com.delogic.tickets.service;

import com.delogic.tickets.domain.User;
import com.delogic.tickets.dto.UserDTO;
import com.delogic.tickets.mapper.UserMapper;
import com.delogic.tickets.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_Success() {
        User user = new User();
        UserDTO userDTO = UserDTO.builder().build();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(user)).thenReturn(userDTO);

        Optional<UserDTO> result = userService.getById(1L);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userDTO);
    }

    @Test
    public void testGetById_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<UserDTO> result = userService.getById(1L);

        assertThat(result).isNotPresent();
    }

    @Test
    public void testGetAllIdsOrUrls_Ids() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(userRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = userService.getAllIdsOrUrls(0, 10, false);

        assertThat(result).isEqualTo(ids);
    }

    @Test
    public void testGetAllIdsOrUrls_Urls() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/users");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Long> ids = List.of(1L, 2L, 3L);
        List<String> urls = ids.stream().map(id -> "http://localhost/api/users/" + id).collect(Collectors.toList());
        when(userRepository.findAllIds(PageRequest.of(0, 10))).thenReturn(new PageImpl<>(ids));

        List<?> result = userService.getAllIdsOrUrls(0, 10, true);

        assertThat(result).isEqualTo(urls);
        RequestContextHolder.resetRequestAttributes();
    }
}