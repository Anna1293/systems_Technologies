package com.example.systems_technologies.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class ApplicationProperties {

    private String uri;
    private String username;
    private String password;
    private String driverClassName;

}