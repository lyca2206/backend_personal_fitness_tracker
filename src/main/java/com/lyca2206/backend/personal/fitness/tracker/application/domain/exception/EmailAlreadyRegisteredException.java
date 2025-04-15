package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {
    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}