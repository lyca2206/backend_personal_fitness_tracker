package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignInRequest;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignInResponse;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.signUp(
                new User(
                        signUpRequest.email(),
                        signUpRequest.password(),
                        signUpRequest.role(),
                        signUpRequest.firstName(),
                        signUpRequest.lastName()
                )
        );
    }

    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) {
        String token = userService.signIn(
                new User(signInRequest.email(), signInRequest.password())
        );

        return new SignInResponse(token);
    }
}