package com.portlogistics.port_logistics_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.portlogistics.port_logistics_system.security.JWTAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JWTAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JWTAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/api/auth/**").permitAll()

                .requestMatchers("/api/users/**")
                    .hasRole("ADMIN")

                .requestMatchers("/api/containers/**")
                    .hasAnyRole("ADMIN", "STAFF")

                .requestMatchers("/api/yard-slots/**")
                    .hasAnyRole("ADMIN", "STAFF")

                .requestMatchers("/api/trucks/**")
                    .hasAnyRole("ADMIN", "STAFF")

                .requestMatchers("/api/movements/**")
                    .hasAnyRole("ADMIN", "STAFF")

                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}