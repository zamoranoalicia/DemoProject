package org.azamorano.demoproject.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ErrorConfig {
    private String code;
    private String message;
}
