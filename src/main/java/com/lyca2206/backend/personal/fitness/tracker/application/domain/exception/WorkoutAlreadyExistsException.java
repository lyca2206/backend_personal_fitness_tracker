package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class WorkoutAlreadyExistsException extends RuntimeException {
    public WorkoutAlreadyExistsException(String message) {
        super(message);
    }
}