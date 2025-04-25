package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.ExerciseNotFoundException;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.ExerciseAlreadyExistsException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.ExerciseRepository;

import java.util.List;

public class ExerciseServiceProvider implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceProvider(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> viewExercise() {
        List<Exercise> exercises = exerciseRepository.findAll();

        if (exercises.isEmpty()) {
            throw new ExerciseNotFoundException("There are no exercises registered in the system");
        }

        return exercises;
    }

    @Override
    public Exercise viewExercise(String name) {
        Exercise exercise = exerciseRepository.findByName(name);

        if (exercise == null) {
            throw new ExerciseNotFoundException("The exercise with name " + name + " does not exist");
        }

        return exercise;
    }

    @Override
    public void createExercise(Exercise exercise) {
        boolean exerciseIsFound = exerciseRepository.existsByName(exercise.name());

        if (exerciseIsFound) {
            throw new ExerciseAlreadyExistsException("The given exercise already exists in the system");
        }

        exerciseRepository.save(exercise);
    }
}