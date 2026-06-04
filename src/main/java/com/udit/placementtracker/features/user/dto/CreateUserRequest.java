package com.udit.placementtracker.features.user.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String name;

    private String email;

    private Integer totalApplications;

}
