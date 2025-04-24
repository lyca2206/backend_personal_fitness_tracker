package com.lyca2206.backend.personal.fitness.tracker.presentation.dto;

public record CreateExerciseRequest(
        String name,
        String measureUnit,
        float caloriesPerUnit
) {}