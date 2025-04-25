package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignInDTO;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignInResponse;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.SignUpDTO;
import com.lyca2206.backend.personal.fitness.tracker.presentation.mapper.SignInDTOMapper;
import com.lyca2206.backend.personal.fitness.tracker.presentation.mapper.SignUpDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final SignUpDTOMapper signUpDTOMapper;
    private final SignInDTOMapper signInDTOMapper;

    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDTO signUpDTO) {
        User user = signUpDTOMapper.SignUpDTOToUser(signUpDTO);
        userService.signUp(user);
    }

    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestBody SignInDTO signInDTO) {
        User user = signInDTOMapper.SignInDTOToUser(signInDTO);
        String token = userService.signIn(user);
        return new SignInResponse(token);
    }
}