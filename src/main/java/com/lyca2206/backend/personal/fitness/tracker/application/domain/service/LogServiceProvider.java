package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.exception.LogNotFoundException;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.LogService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.LogRepository;

import java.util.List;

public class LogServiceProvider implements LogService {
    private final LogRepository logRepository;

    public LogServiceProvider(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> viewLog(User user) {
        List<Log> logs = logRepository.findByUser(user);

        if (logs.isEmpty()) {
            throw new LogNotFoundException("There are no logs registered in the system");
        }

        return logs;
    }

    @Override
    public Log viewLog(User user, int index) {
        List<Log> logs = viewLog(user);

        if (index - 1 >= logs.size()) {
            throw new LogNotFoundException("The given log index does not exist");
        }

        return logs.get(index);
    }

    @Override
    public void createLog(Log log) {
        logRepository.save(log);
    }
}