package com.lyca2206.backend.personal.fitness.tracker.application.api;

public interface ExerciseService {
    void createExercise(String name, String measureUnit, float caloriesPerUnit);
}