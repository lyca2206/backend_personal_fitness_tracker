package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.WorkoutService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.WorkoutDTO;
import com.lyca2206.backend.personal.fitness.tracker.presentation.mapper.WorkoutDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workout")
public class WorkoutController {
    private final WorkoutService workoutService;
    private final WorkoutDTOMapper workoutDTOMapper;

    @GetMapping
    public List<Workout> viewWorkout() {
        return workoutService.viewWorkout();
    }

    @GetMapping("/{name}")
    public Workout viewWorkout(@PathVariable String name) {
        return workoutService.viewWorkout(name);
    }

    @PostMapping
    public void createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        Workout workout = workoutDTOMapper.WorkoutDTOToWorkout(workoutDTO);
        workoutService.createWorkout(workout);
    }
}