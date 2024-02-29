package org.azamorano.demoproject.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.azamorano.demoproject.config.ErrorProperties;
import org.azamorano.demoproject.dto.EventRequestDTO;

import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class EventMapper {
    private final ObjectMapper objectMapper;
    private final ErrorProperties errorProperties;

    public String convertToJson(final EventRequestDTO eventRequestDTO) {
        try {
            return objectMapper.writeValueAsString(eventRequestDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
