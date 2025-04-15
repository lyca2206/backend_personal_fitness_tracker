package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

public interface ExerciseService {
    void createExercise(String name, String measureUnit, float caloriesPerUnit);
}