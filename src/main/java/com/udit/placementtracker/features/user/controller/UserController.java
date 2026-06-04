package com.udit.placementtracker.features.user.controller;

import com.udit.placementtracker.features.user.entity.User;
import com.udit.placementtracker.features.user.service.UserService;
import com.udit.placementtracker.features.user.dto.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(
            @RequestBody CreateUserRequest request
    ) {
        return userService.createUser(request);
    }
}
