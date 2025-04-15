package com.lyca2206.backend_personal_fitness_tracker.application.spi;

import com.lyca2206.backend_personal_fitness_tracker.application.domain.model.Exercise;

public interface ExerciseRepository {
    void save(Exercise exercise);
    boolean existsByName(String name);
}