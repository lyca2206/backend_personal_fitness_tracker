package com.lyca2206.backend_personal_fitness_tracker.application.domain.usecase;

import com.lyca2206.backend_personal_fitness_tracker.application.api.UserService;
import com.lyca2206.backend_personal_fitness_tracker.application.domain.model.User;
import com.lyca2206.backend_personal_fitness_tracker.application.spi.UserRepository;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

public class UserUseCase implements UserService {
    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String email, String password, String role, String firstName, String lastName) throws InstanceAlreadyExistsException {
        User user = new User(email, password, role, firstName, lastName);

        boolean userIsFound = userRepository.existsByEmail(user.getEmail());
        if (userIsFound) {
            throw new InstanceAlreadyExistsException("The given email already exists in the system");
        }

        userRepository.save(user);
    }

    @Override
    public void signIn(String email, String password) throws InstanceNotFoundException {
        User user = new User(email, password);
        User storedUser = userRepository.findByEmail(user.getEmail());

        if (storedUser == null) {
            throw new InstanceNotFoundException("The given user doesn't exist in the system");
        }

        //TODO.
        throw new RuntimeException("Not yet implemented");
    }
}