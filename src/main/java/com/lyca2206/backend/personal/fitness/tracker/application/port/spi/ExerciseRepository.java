package com.lyca2206.backend.personal.fitness.tracker.application.port.spi;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;

import java.util.List;

public interface ExerciseRepository {
    List<Exercise> findAll();
    void save(Exercise exercise);
    Exercise findByName(String name);
    boolean existsByName(String name);
}