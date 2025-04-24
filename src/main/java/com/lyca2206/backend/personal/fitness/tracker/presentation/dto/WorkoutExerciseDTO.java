package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

public record WorkoutExerciseDTO(
        ExerciseDTO exercise,
        int sets,
        float units
) {}