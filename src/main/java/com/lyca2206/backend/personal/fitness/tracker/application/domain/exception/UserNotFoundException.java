package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}