package com.lyca2206.backend_personal_fitness_tracker.application.api;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

public interface UserService {
    void signUp(String email, String password, String role, String firstName, String lastName) throws InstanceAlreadyExistsException;
    void signIn(String email, String password) throws InstanceNotFoundException;
}