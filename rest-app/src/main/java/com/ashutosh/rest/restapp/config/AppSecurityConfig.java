package com.ashutosh.rest.restapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
public class AppSecurityConfig {

//    In memory user save
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails ashu= User.builder()
                .username("ashu")
                .password("{noop}ashu")
                .roles("USER")
                .build();
        UserDetails manu= User.builder()
                .username("manu")
                .password("{noop}manu")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(ashu,manu);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"/api/employees")
                        .hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf-> csrf.disable());
        return http.build();
    }
}
