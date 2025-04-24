package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

public interface UserService {
    void signUp(String email, String password, String role, String firstName, String lastName);
    String signIn(String email, String password);
}