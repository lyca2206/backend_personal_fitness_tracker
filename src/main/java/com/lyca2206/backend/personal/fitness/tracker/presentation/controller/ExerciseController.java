package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.ExerciseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping
    public void createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        exerciseService.createExercise(
                exerciseDTO.name(),
                exerciseDTO.measureUnit(),
                exerciseDTO.caloriesPerUnit()
        );
    }
}