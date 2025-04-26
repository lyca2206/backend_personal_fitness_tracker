package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.LogRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.*;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.LogEntityMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.ExerciseLogRepositoryJPA;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.LogRepositoryJPA;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.UserRepositoryJPA;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.WorkoutRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class LogRepositoryAdapter implements LogRepository {
    private final LogRepositoryJPA logRepositoryJPA;
    private final WorkoutRepositoryJPA workoutRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final ExerciseLogRepositoryJPA exerciseLogRepositoryJPA;
    private final LogEntityMapper logEntityMapper;

    @Override
    public List<Log> findByUser(User user) {
        return List.of();
    }

    @Override
    public void save(Log log) {
        LogEntity logEntity = logEntityMapper.LogToLogEntity(log);

        WorkoutEntity workoutEntity = workoutRepositoryJPA.findByName(log.getWorkout().name());
        logEntity.setWorkout(workoutEntity);

        UserEntity userEntity = userRepositoryJPA.findByEmail(log.getUser().getEmail());
        logEntity.setUser(userEntity);

        logRepositoryJPA.save(logEntity);

        List<ExerciseLogEntity> exerciseLogEntities = logEntity.getExerciseLogs();
        List<WorkoutExerciseEntity> workoutExerciseEntities = workoutEntity.getWorkoutExercises();

        for (int i = 0; i < exerciseLogEntities.size(); i++) {
            exerciseLogEntities.get(i).setLog(logEntity);
            exerciseLogEntities.get(i).setWorkoutExercise(workoutExerciseEntities.get(i));

            exerciseLogRepositoryJPA.save(exerciseLogEntities.get(i));
        }
    }
}