package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.LogRepository;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.LogEntity;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper.LogEntityMapper;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.repository.LogRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class LogRepositoryAdapter implements LogRepository {
    private final LogRepositoryJPA logRepositoryJPA;
    private final LogEntityMapper logEntityMapper;

    @Override
    public List<Log> findByUser(User user) {
        return List.of();
    }

    @Override
    public void save(Log log) {
        LogEntity logEntity = logEntityMapper.LogToLogEntity(log);
        //TODO: In order to save, this entity needs to have the Workout ID and the User ID!
        //logRepositoryJPA.save(logEntity);
    }
}