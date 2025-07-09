package com.cardekho.carsearch.messaging;

import com.cardekho.carsearch.model.EsCar;
import com.cardekho.carsearch.repository.EsCarRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarEventConsumer {
    private final ObjectMapper objectMapper;
    private final EsCarRepository esCarRepository;

    @KafkaListener(topics = "car.events")
    public void consume(String message) {
        try {
            CarEvent event = objectMapper.readValue(message, CarEvent.class);
            
            switch (event.eventType()) {
                case "CREATED":
                case "UPDATED":
                    esCarRepository.save(convertToEsCar(event.car()));
                    break;
                case "DELETED":
                    esCarRepository.deleteById(event.car().id().toString());
                    break;
            }
        } catch (JsonProcessingException e) {
            log.error("Error processing car event", e);
        }
    }

    private EsCar convertToEsCar(CarEvent.CarDto car) {
        return EsCar.builder()
                .id(car.id().toString())
                .model(car.model())
                .year(car.year())
                .color(car.color())
                .price(car.price())
                .fuelType(car.fuelType())
                .transmission(car.transmission())
                .brandId(car.brandId())
                .manufacturerId(car.manufacturerId())
                .build();
    }

    public record CarEvent(CarDto car, String eventType) {
        public record CarDto(
            Long id,
            String model,
            Integer year,
            String color,
            Double price,
            String fuelType,
            String transmission,
            Long brandId,
            Long manufacturerId
        ) {}
    }
}
