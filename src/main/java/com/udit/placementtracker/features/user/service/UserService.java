package com.udit.placementtracker.features.user.service;

import com.udit.placementtracker.features.user.dto.CreateUserRequest;
import com.udit.placementtracker.features.user.entity.User;
import com.udit.placementtracker.features.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setTotalApplications(request.getTotalApplications());

        return userRepository.save(user);
    }
}
