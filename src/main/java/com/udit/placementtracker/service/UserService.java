package com.udit.placementtracker.service;

import com.udit.placementtracker.dto.CreateUserRequest;
import com.udit.placementtracker.entity.User;
import com.udit.placementtracker.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setTotalApplications(request.getTotalApplications());

        return userRepository.save(user);
    }
}