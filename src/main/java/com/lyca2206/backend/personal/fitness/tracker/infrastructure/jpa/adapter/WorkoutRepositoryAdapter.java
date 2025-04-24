package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.WorkoutRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.WorkoutMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.WorkoutRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class WorkoutRepositoryAdapter implements WorkoutRepository {
    private WorkoutRepositoryJPA workoutRepositoryJPA;
    private WorkoutMapper workoutMapper;

    @Override
    public List<Workout> findAll() {
        return workoutRepositoryJPA.findAll().stream()
                .map(workoutEntity ->
                        workoutMapper.workoutEntityToWorkout(workoutEntity)
                ).toList();
    }

    @Override
    public Workout findByName(String name) {
        WorkoutEntity workoutEntity = workoutRepositoryJPA.findByName(name);
        return workoutMapper.workoutEntityToWorkout(workoutEntity);
    }
}