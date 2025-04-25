package com.lyca2206.backend.personal.fitness.tracker.application.port.api;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.Log;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.model.User;

import java.util.List;

public interface LogService {
    List<Log> viewLog(User user);
    Log viewLog(User user, int index);
    void createLog(Log log);
}