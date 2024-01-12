package com.application.pos.inventory.infrastructure.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("success.status")
public class SuccessResponseProperties {
    private String code;
    private String description;
}
