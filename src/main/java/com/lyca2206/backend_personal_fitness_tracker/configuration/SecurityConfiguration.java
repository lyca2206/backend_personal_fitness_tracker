package com.lyca2206.backend_personal_fitness_tracker.configuration;

import com.lyca2206.backend_personal_fitness_tracker.configuration.filter.JWTAuthenticationFilter;
import com.lyca2206.backend_personal_fitness_tracker.configuration.utilities.KeyPairHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import java.nio.file.Path;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security, JWTAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        security
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterAfter(
                        jwtAuthenticationFilter,
                        AnonymousAuthenticationFilter.class
                )
                .authorizeHttpRequests(authorization -> authorization
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/user/*").permitAll()
                        .anyRequest().authenticated()
                );

        return security.build();
    }

    @Bean
    public KeyPairHolder keyPairHolder (
            @Value("${public.key.location}") Path publicKeyPath,
            @Value("${private.key.location}") Path privateKeyPath
    ) {
        return new KeyPairHolder(publicKeyPath, privateKeyPath);
    }
}