package com.lyca2206.backend.personal.fitness.tracker.configuration;

import com.lyca2206.backend.personal.fitness.tracker.application.domain.service.LogServiceProvider;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.service.WorkoutServiceProvider;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.LogService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.service.ExerciseServiceProvider;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.service.UserServiceProvider;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.WorkoutService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.ExerciseRepository;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.LogRepository;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.PasswordMatcherService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.UserRepository;
import com.lyca2206.backend.personal.fitness.tracker.configuration.utilities.KeyPairHolder;
import com.lyca2206.backend.personal.fitness.tracker.infrastructure.jpa.adapter.WorkoutRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@Configuration
public class BeanConfiguration {
    @Bean
    public ExerciseService exerciseService(ExerciseRepository exerciseRepository) {
        return new ExerciseServiceProvider(exerciseRepository);
    }

    @Bean
    public UserService userService(
            KeyPairHolder keyPairHolder,
            UserRepository userRepository,
            PasswordMatcherService passwordEncoderAdapter
    ) {
        return new UserServiceProvider(3600, keyPairHolder.getPrivate(), passwordEncoderAdapter, userRepository);
    }

    @Bean
    public WorkoutService workoutService(WorkoutRepositoryAdapter workoutRepositoryAdapter) {
        return new WorkoutServiceProvider(workoutRepositoryAdapter);
    }

    @Bean
    public LogService logService(LogRepository logRepository) {
        return new LogServiceProvider(logRepository);
    }

    @Bean
    public Supplier<List<?>> listSupplier() {
        return LinkedList::new;
    }
}