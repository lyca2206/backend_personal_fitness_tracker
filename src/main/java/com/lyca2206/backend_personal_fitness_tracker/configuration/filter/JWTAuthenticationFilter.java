package com.lyca2206.backend_personal_fitness_tracker.configuration.filter;

import com.lyca2206.backend_personal_fitness_tracker.application.domain.model.Role;
import com.lyca2206.backend_personal_fitness_tracker.configuration.utilities.KeyPairHolder;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private KeyPairHolder keyPairHolder;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        if (authorization != null) {
            validateJWT(authorization);
            authenticate();
        }

        filterChain.doFilter(request, response);
    }

    private void validateJWT(String authorization) {
        String jwt = authorization.substring("Bearer ".length());

        Jwts.parser()
                .verifyWith(keyPairHolder.getPublic())
                .build()
                .parseSignedClaims(jwt);
    }

    private void authenticate() {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        //TODO: Change this UsernamePasswordAuthenticationToken!
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                null,
                null,
                List.of(new SimpleGrantedAuthority(Role.REGULAR.name()))
        );

        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
    }
}