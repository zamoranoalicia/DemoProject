package org.azamorano.demoproject.config;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@ConfigurationProperties(prefix = "errors")
public class ErrorProperties {
    private ErrorConfig conversionJson;
}
