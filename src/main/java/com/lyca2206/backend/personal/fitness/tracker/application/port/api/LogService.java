package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;

import java.util.List;

public interface LogService {
    List<Log> viewLog();
    Log viewLog(String id);
    void createLog(Log log);
}