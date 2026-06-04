package com.udit.placementtracker.controller;

import com.udit.placementtracker.entity.User;
import com.udit.placementtracker.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.udit.placementtracker.dto.CreateUserRequest;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createUser(
            @RequestBody CreateUserRequest request
    ) {
        return userService.createUser(request);
    }
}