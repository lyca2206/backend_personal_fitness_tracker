package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

import java.util.List;

public record LogDTO(
        String workoutName,
        List<Float> exerciseLogs
) {}