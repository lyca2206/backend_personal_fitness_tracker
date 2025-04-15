package com.lyca2206.backend.personal.fitness.tracker.application.domain.usecase;

import com.lyca2206.backend.personal.fitness.tracker.application.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.application.spi.ExerciseRepository;

import javax.management.InstanceAlreadyExistsException;

public class ExerciseUseCase implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseUseCase(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void createExercise(String name, String measureUnit, float caloriesPerUnit) throws InstanceAlreadyExistsException {
        Exercise exercise = new Exercise(name, measureUnit, caloriesPerUnit);

        boolean exerciseIsFound = exerciseRepository.existsByName(exercise.name());
        if (exerciseIsFound) {
            throw new InstanceAlreadyExistsException("The given exercise already exists in the system");
        }

        exerciseRepository.save(exercise);
    }
}