package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.ExerciseAlreadyExistsException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.ExerciseRepository;

public class ExerciseServiceProvider implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceProvider(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void createExercise(String name, String measureUnit, float caloriesPerUnit) {
        Exercise exercise = new Exercise(name, measureUnit, caloriesPerUnit);

        boolean exerciseIsFound = exerciseRepository.existsByName(exercise.name());
        if (exerciseIsFound) {
            throw new ExerciseAlreadyExistsException("The given exercise already exists in the system");
        }

        exerciseRepository.save(exercise);
    }
}