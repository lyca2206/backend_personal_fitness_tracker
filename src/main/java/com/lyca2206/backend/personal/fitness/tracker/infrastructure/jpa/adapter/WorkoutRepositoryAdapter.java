package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Workout;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.WorkoutRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.WorkoutEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.WorkoutEntityMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.WorkoutRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class WorkoutRepositoryAdapter implements WorkoutRepository {
    private WorkoutRepositoryJPA workoutRepositoryJPA;
    private WorkoutEntityMapper workoutEntityMapper;

    @Override
    public List<Workout> findAll() {
        return workoutRepositoryJPA.findAll().stream()
                .map(workoutEntity ->
                        workoutEntityMapper.workoutEntityToWorkout(workoutEntity)
                ).toList();
    }

    @Override
    public Workout findByName(String name) {
        WorkoutEntity workoutEntity = workoutRepositoryJPA.findByName(name);
        return workoutEntityMapper.workoutEntityToWorkout(workoutEntity);
    }
}