package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

public record SignInRequest(
        String email,
        String password
) {}