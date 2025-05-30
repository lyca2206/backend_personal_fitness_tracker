package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

import java.util.List;

public record WorkoutDTO(
        String name,
        String description,
        List<WorkoutExerciseDTO> workoutExercises,
        String notes
) {}