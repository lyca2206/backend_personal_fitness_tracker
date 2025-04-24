package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.WorkoutNotFoundException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.WorkoutService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.WorkoutRepository;

import java.util.List;

public class WorkoutServiceProvider implements WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutServiceProvider(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public List<Workout> viewWorkout() {
        List<Workout> workouts = workoutRepository.findAll();

        if (workouts.isEmpty()) {
            throw new WorkoutNotFoundException("There are no workouts registered in the system");
        }

        return workouts;
    }

    @Override
    public Workout viewWorkout(String name) {
        Workout workout = workoutRepository.findByName(name);

        if (workout == null) {
            throw new WorkoutNotFoundException("The workout with name " + name + " does not exist");
        }

        return workout;
    }

    @Override
    public void createWorkout() {}
}