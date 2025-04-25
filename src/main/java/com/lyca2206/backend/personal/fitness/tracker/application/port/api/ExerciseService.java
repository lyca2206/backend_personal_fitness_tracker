package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> viewExercise();
    Exercise viewExercise(String name);
    void createExercise(Exercise exercise);
}