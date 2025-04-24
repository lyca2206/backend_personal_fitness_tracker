package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/workout")
public class WorkoutController {
    @GetMapping
    public void viewWorkout() {
        //TODO.
    }

    @GetMapping("/{name}")
    public void viewWorkout(@PathVariable String name) {
        //TODO.
    }

    @PostMapping
    public void createWorkout() {
        //TODO.
    }
}