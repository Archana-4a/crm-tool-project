package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for frontend testing
            .cors(cors -> {})             // enable CORS using your CorsConfig
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()); // allow all requests (customize as needed)

        return http.build();
    }
}
