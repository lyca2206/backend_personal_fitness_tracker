package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

public record WorkoutExerciseDTO(
        String exerciseName,
        int sets,
        float units
) {}