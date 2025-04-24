package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/log")
public class LogController {
    @GetMapping
    public void viewLog() {
        //TODO.
    }

    @GetMapping("/{id}")
    public void viewLog(String id) {
        //TODO.
    }

    @PostMapping
    public void createLog() {
        //TODO.
    }
}