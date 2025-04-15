package com.lyca2206.backend_personal_fitness_tracker.configuration;

import com.lyca2206.backend_personal_fitness_tracker.application.api.ExerciseService;
import com.lyca2206.backend_personal_fitness_tracker.application.api.UserService;
import com.lyca2206.backend_personal_fitness_tracker.application.domain.usecase.ExerciseUseCase;
import com.lyca2206.backend_personal_fitness_tracker.application.domain.usecase.UserUseCase;
import com.lyca2206.backend_personal_fitness_tracker.application.spi.ExerciseRepository;
import com.lyca2206.backend_personal_fitness_tracker.application.spi.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ExerciseService exerciseService(ExerciseRepository exerciseRepository) {
        return new ExerciseUseCase(exerciseRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserUseCase(userRepository);
    }
}