package com.lyca2206.backend.personal.fitness.tracker.application.domain.service;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.LogService;

import java.util.List;

public class LogServiceProvider implements LogService {
    @Override
    public Log viewLog() {
        return null;
    }

    @Override
    public List<Log> viewLog(String id) {
        return List.of();
    }

    @Override
    public void createLog() {}
}