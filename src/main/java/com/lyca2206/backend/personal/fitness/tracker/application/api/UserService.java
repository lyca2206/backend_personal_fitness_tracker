package com.lyca2206.backend.personal.fitness.tracker.application.api;

public interface UserService {
    void signUp(String email, String password, String role, String firstName, String lastName);
    void signIn(String email, String password);
}