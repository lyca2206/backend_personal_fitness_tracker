package com.lyca2206.backend_personal_fitness_tracker.presentation.dto;

public record CreateExerciseDTO(
        String name,
        String measureUnit,
        float caloriesPerUnit
) {}