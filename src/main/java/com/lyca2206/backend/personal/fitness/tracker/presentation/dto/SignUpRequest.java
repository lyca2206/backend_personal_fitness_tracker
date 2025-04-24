package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

public record SignUpRequest(
        String email,
        String password,
        String role,
        String firstName,
        String lastName
) {}