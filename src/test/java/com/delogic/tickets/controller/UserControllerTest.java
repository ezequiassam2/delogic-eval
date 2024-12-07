package com.delogic.tickets.controller;

import com.delogic.tickets.dto.UserDTO;
import com.delogic.tickets.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUserIdsOrUrls_Success() {
        List userList = Collections.singletonList(1L);
        when(userService.getAllIdsOrUrls(0, 10, false)).thenReturn(userList);

        ResponseEntity<List<?>> response = userController.getAllUserIdsOrUrls(0, 10, false);

        assertEquals(ResponseEntity.ok(userList), response);
    }

    @Test
    public void testGetUserById_Success() {
        UserDTO userDTO = UserDTO.builder().build();
        when(userService.getById(1L)).thenReturn(Optional.of(userDTO));

        ResponseEntity<UserDTO> response = userController.getUserById(1L);

        assertEquals(ResponseEntity.ok(userDTO), response);
    }

    @Test
    public void testGetUserById_NotFound() {
        when(userService.getById(1L)).thenReturn(Optional.empty());

        ResponseEntity<UserDTO> response = userController.getUserById(1L);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}