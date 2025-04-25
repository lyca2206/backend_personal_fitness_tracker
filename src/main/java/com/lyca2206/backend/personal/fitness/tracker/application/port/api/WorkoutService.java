package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;

import java.util.List;

public interface WorkoutService {
    List<Workout> viewWorkout();
    Workout viewWorkout(String name);
    void createWorkout(Workout workout);
}