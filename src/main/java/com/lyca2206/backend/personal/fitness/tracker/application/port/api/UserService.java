package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;

public interface UserService {
    void signUp(User user);

    String signIn(User user);
}