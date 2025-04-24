package com.lyca2206.backend.personal.fitness.tracker.configuration;

import com.lyca2206.backend.personal.fitness.tracker.application.port.api.ExerciseService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.api.UserService;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.service.ExerciseServiceProvider;
import com.lyca2206.backend.personal.fitness.tracker.application.domain.service.UserServiceProvider;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.ExerciseRepository;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.PasswordMatcherService;
import com.lyca2206.backend.personal.fitness.tracker.application.port.spi.UserRepository;
import com.lyca2206.backend.personal.fitness.tracker.configuration.utilities.KeyPairHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return new UserServiceProvider(3600, keyPairHolder.getPrivate(), userRepository, passwordEncoderAdapter);
    }
}