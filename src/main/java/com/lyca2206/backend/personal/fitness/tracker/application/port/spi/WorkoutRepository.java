package com.lyca2206.backend.personal.fitness.tracker.application.port.spi;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;

import java.util.List;

public interface WorkoutRepository {
    List<Workout> findAll();
    void save(Workout workout);
    Workout findByName(String name);
    boolean existsByName(String name);
}