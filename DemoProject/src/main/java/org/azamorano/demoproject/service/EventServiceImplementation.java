package org.azamorano.demoproject.service;

import lombok.AllArgsConstructor;
import org.azamorano.demoproject.config.EventProperties;
import org.azamorano.demoproject.dto.EventRequestDTO;
import org.azamorano.demoproject.mapper.EventMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImplementation implements EventService{
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EventProperties eventProperties;
    private final EventMapper eventMapper;

    @Override
    public void sendEvent(final String event) {
        this.kafkaTemplate.send(this.eventProperties.getDefaultTopic(), event);
    }

    @Override
    public void sendEvent(final EventRequestDTO event) {
        this.kafkaTemplate.send(this.eventProperties.getDefaultTopic(), eventMapper.convertToJson(event));
    }
}
