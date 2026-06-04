package com.udit.placementtracker.features.user.controller;

import com.udit.placementtracker.features.user.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    /**
     * This route allows a logged-in user to see their own details.
     * @AuthenticationPrincipal automatically injects the User object that 
     * was loaded into the SecurityContext by our JwtAuthenticationFilter.
     */
    @GetMapping("/me")
    public User getMyDetails(@AuthenticationPrincipal User currentUser) {
        return currentUser;
    }
}
