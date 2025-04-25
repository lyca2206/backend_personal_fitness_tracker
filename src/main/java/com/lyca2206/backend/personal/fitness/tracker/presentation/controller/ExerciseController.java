package com.lyca2206.backend.personal.fitness.tracker.presentation.controller;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Exercise;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.presentation.dto.ExerciseDTO;
import com.lyca2206.backend.personal.fitness.tracker.presentation.mapper.ExerciseDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ExerciseDTOMapper exerciseDTOMapper;

    @GetMapping
    public List<Exercise> viewExercise() {
        return exerciseService.viewExercise();
    }

    @GetMapping("/{name}")
    public Exercise viewExercise(String name) {
        return exerciseService.viewExercise(name);
    }

    @PostMapping
    public void createExercise(@RequestBody ExerciseDTO exerciseDTO) {
        Exercise exercise = exerciseDTOMapper.ExerciseDTOToExercise(exerciseDTO);
        exerciseService.createExercise(exercise);
    }
}