package com.cardekho.car_catalog.event;

import com.cardekho.car_catalog.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    
    public void sendCarEvent(String topic, Car car, String eventType) {
        try {
            String payload = objectMapper.writeValueAsString(new CarEvent(car, eventType));
            kafkaTemplate.send(topic, payload);
        } catch (JsonProcessingException e) {
            log.error("Error serializing car event", e);
        }
    }
    
    public record CarEvent(Car car, String eventType) {}
}
