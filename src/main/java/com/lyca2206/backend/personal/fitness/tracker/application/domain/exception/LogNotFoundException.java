package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class LogNotFoundException extends RuntimeException {
    public LogNotFoundException(String message) {
        super(message);
    }
}