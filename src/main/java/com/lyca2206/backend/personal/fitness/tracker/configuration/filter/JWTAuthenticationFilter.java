package com.lyca2206.backend.personal.fitness.tracker.configuration.filter;

import com.lyca2206.backend.personal.fitness.tracker.configuration.utilities.KeyPairHolder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

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
            String jwt = authorization.substring("Bearer ".length());
            Jws<Claims> jws = validateJWT(jwt);
            authenticate(jwt, jws);
        }

        filterChain.doFilter(request, response);
    }

    private Jws<Claims> validateJWT(String jwt) {
        return Jwts.parser()
                .verifyWith(keyPairHolder.getPublic())
                .build()
                .parseSignedClaims(jwt);
    }

    private void authenticate(String jwt, Jws<Claims> jws) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        Authentication authentication = new JwtAuthenticationToken(
                new Jwt(
                        jwt,
                        jws.getPayload().getIssuedAt().toInstant(),
                        jws.getPayload().getExpiration().toInstant(),
                        jws.getHeader(),
                        jws.getPayload()
                )
        );
        authentication.setAuthenticated(true);

        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
    }
}