package com.fundy.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ApplicationConfig extends SpringBootServletInitializer {

    @Value("${spring.profiles.active:#{null}}")
    private String activeProfile;

    @EventListener(ApplicationReadyEvent.class)
    public void logProfile() {
        if(activeProfile == null){
            log.warn("Profile isn't set");
            return;
        }
        log.info("Current profile: {}", activeProfile);
    }
}
