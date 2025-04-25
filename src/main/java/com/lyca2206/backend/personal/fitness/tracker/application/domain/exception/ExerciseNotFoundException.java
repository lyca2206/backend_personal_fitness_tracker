package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException(String message) {
        super(message);
    }
}