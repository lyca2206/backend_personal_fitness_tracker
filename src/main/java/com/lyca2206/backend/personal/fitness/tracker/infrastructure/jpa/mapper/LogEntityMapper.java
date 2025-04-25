package com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.mapper;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.entity.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { WorkoutEntityMapper.class, ExerciseLogEntityMapper.class, UserEntityMapper.class })
public interface LogEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateTime", source = "time")
    LogEntity LogToLogEntity(Log log);
}