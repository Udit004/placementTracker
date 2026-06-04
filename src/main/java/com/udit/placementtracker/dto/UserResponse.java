package com.udit.placementtracker.dto;

import lombok.Data;

@Data
public class UserResponse {

    private String name;
    private String email;
    private Integer totalApplications;

}