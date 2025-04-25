package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.LogService;

import java.util.List;

public class LogServiceProvider implements LogService {
    @Override
    public List<Log> viewLog() {
        return List.of();
    }

    @Override
    public Log viewLog(String id) {
        return null;
    }

    @Override
    public void createLog(Log log) {}
}