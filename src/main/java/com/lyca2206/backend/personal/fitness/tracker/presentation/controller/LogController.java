package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.ExerciseLog;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.LogService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.LogDTO;
import com.lyca2206.backend.personal.fitness.tracker.presentation.mapper.LogDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@AllArgsConstructor
@RestController
@RequestMapping("/log")
public class LogController {
    private final Supplier<List<ExerciseLog>> listSupplier;
    private final LogService logService;
    private final LogDTOMapper logDTOMapper;

    @GetMapping
    public Log viewLog() {
        return logService.viewLog();
    }

    @GetMapping("/{id}")
    public List<Log> viewLog(String id) {
        return logService.viewLog(id);
    }

    @PostMapping
    public void createLog(@RequestBody LogDTO logDTO) {
        User user = getAuthenticatedUser();
        Log log = logDTOMapper.LogDTOToLog(logDTO, listSupplier, user);
        //TODO.
        System.out.println(log);
    }

    private User getAuthenticatedUser() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, ?> map = jwt.getClaim("user");

        String email = (String) map.get("email");
        String role = (String) map.get("role");
        String firstName = (String) map.get("firstName");
        String lastName = (String) map.get("lastName");

        return new User(email, null, role, firstName, lastName);
    }
}