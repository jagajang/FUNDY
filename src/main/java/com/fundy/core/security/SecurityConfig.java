package com.fundy.core.security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest().permitAll() //-> 다른 모든 url은 인증된 사용자에 대해서만 허용
                .and()
                .formLogin()
                    .loginPage("/login") // /login에 대한 url 요청을 다 가져감
                    .permitAll();
        return http.build();
    }
}