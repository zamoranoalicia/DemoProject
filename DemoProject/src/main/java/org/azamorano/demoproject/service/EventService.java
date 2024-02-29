package org.azamorano.demoproject.service;

import org.azamorano.demoproject.dto.EventRequestDTO;

public interface EventService {
    void sendEvent(final String event);
    void sendEvent(final EventRequestDTO event);
}
