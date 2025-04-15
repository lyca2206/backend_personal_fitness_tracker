package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.EmailAlreadyRegisteredException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.UserNotFoundException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.UserRepository;

public class UserServiceProvider implements UserService {
    private final UserRepository userRepository;

    public UserServiceProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String email, String password, String role, String firstName, String lastName) {
        User user = new User(email, password, role, firstName, lastName);

        boolean userIsFound = userRepository.existsByEmail(user.getEmail());
        if (userIsFound) {
            throw new EmailAlreadyRegisteredException("The given email is already associated with an user");
        }

        userRepository.save(user);
    }

    @Override
    public void signIn(String email, String password) {
        User user = new User(email, password);
        User storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser == null) {
            throw new UserNotFoundException("The given user doesn't exist in the system");
        }

        //TODO.
        throw new RuntimeException("Not yet implemented");
    }
}