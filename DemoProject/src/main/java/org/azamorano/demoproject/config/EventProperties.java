package org.azamorano.demoproject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka.template")
@Data
public class EventProperties {
    private String defaultTopic;
}
