package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

public record ExerciseDTO(
        String name,
        String measureUnit,
        float caloriesPerUnit
) {}