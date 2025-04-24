package com.lyca2206.backend.personal.fitness.tracker.application.domain.exception;

public class CredentialsDoNotMatchException extends RuntimeException {
    public CredentialsDoNotMatchException(String message) {
        super(message);
    }
}