package com.udit.placementtracker.features.auth.controller;

import com.udit.placementtracker.features.auth.dto.AuthResponse;
import com.udit.placementtracker.features.auth.dto.LoginRequest;
import com.udit.placementtracker.features.auth.service.AuthService;
import com.udit.placementtracker.features.user.dto.CreateUserRequest;
import com.udit.placementtracker.features.user.entity.User;
import com.udit.placementtracker.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
}
