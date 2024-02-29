package org.azamorano.demoproject.producer;

import lombok.extern.slf4j.Slf4j;
import org.azamorano.demoproject.event.TestEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
    public static final String TOPIC = "my-topic";

    private final KafkaTemplate<String, TestEvent> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, TestEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendFlightEvent(TestEvent event){
        String key = event.getKey();
        kafkaTemplate.send(TOPIC, key , event);
        log.info("Producer produced the message {}", event);
    }
}
