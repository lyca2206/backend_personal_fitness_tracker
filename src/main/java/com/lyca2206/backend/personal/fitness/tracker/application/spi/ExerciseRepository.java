package com.lyca2206.backend.personal.fitness.tracker.application.spi;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;

public interface ExerciseRepository {
    void save(Exercise exercise);
    boolean existsByName(String name);
}