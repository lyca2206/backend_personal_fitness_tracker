package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;

public interface ExerciseService {
    void createExercise(Exercise exercise);
}