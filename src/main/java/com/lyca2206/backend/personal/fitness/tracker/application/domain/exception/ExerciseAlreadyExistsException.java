package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class ExerciseAlreadyExistsException extends RuntimeException {
    public ExerciseAlreadyExistsException(String message) {
        super(message);
    }
}