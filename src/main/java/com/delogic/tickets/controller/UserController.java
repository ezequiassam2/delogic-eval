package com.delogic.tickets.controller;

import com.delogic.tickets.dto.UserDTO;
import com.delogic.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Long> getAllUserIds(@RequestParam(defaultValue = "${default.page}") int page, @RequestParam(defaultValue = "${default.size}") int size) {
        return userService.getAllUserIds(page, size);
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }
}