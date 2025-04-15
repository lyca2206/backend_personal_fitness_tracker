package com.lyca2206.backend_personal_fitness_tracker.application.api;

import javax.management.InstanceAlreadyExistsException;

public interface ExerciseService {
    void createExercise(String name, String measureUnit, float caloriesPerUnit) throws InstanceAlreadyExistsException;
}