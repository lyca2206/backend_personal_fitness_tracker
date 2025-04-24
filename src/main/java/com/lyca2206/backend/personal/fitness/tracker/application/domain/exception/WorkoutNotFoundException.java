package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class WorkoutNotFoundException extends RuntimeException {
    public WorkoutNotFoundException(String message) {
        super(message);
    }
}