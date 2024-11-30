//package com.bits.bitscure.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/", "/login", "/oauth2/**").permitAll() // Allow these paths without authentication
//                .anyRequest().authenticated()) // All other paths require authentication
//            .oauth2Login(oauth2 -> oauth2
//                .loginPage("/login") // Custom login page if needed
//                .defaultSuccessUrl("/profile", true)); // Redirect after successful login
//
//        
//        return http.build();
//    }
//}
