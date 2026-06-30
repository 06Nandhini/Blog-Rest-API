package com.example.BlogRestAPI.config;

import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // disabling csrf to use put, post, del http methods. since spring default setting filter those things.
        http. 
            csrf(csrf -> csrf.disable())

            
            // enabling h2-console
            .headers(headers ->
                headers
                    .frameOptions(frame ->
                        frame.disable()
                    )
            )

            .authorizeHttpRequests(auth ->
                auth

                .requestMatchers(
                    "/h2-console/"
                )
                .permitAll()

                .anyRequest()
                .authenticated()
            )
            
            .httpBasic(Customizer.withDefaults()); 

            return http.build();
    }
}
