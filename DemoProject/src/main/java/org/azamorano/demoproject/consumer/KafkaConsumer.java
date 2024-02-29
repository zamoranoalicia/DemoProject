package org.azamorano.demoproject.consumer;

import lombok.extern.slf4j.Slf4j;
import org.azamorano.demoproject.dto.EventRequestDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", containerFactory = "NotificationContainerFactory")
    public void listen(@Payload EventRequestDTO eventRequestDTO, Acknowledgment ack) {
        log.info(String.format("Message received -> %s", eventRequestDTO));
        ack.acknowledge();
    }
}
