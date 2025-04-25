package com.lyca2206.backend.personal.fitness.tracker.application.port.spi;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;

import java.util.List;

public interface LogRepository {
    List<Log> findByUser(User user);
    void save(Log log);
}