package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignInDTO;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignUpDTO;
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
    public void signUp(@RequestBody SignUpDTO signUpDTO) {
        userService.signUp(
                signUpDTO.email(),
                signUpDTO.password(),
                signUpDTO.role(),
                signUpDTO.firstName(),
                signUpDTO.lastName()
        );
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody SignInDTO signInDTO) {
        return userService.signIn(
                signInDTO.email(),
                signInDTO.password()
        );
    }
}