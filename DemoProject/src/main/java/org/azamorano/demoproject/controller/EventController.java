package org.azamorano.demoproject.controller;

import org.azamorano.demoproject.dto.EventRequestDTO;
import org.azamorano.demoproject.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/publish")
    public String sendEvent(final @RequestParam("event") String event) {
        this.eventService.sendEvent(event);
        return "Sent event: " + event;
    }

    @PostMapping("/events")
    public String publishEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        eventRequestDTO = eventRequestDTO.toBuilder().startTime(LocalDateTime.now()).build();
        this.eventService.sendEvent(eventRequestDTO);
        return "Event published";
    }
}
