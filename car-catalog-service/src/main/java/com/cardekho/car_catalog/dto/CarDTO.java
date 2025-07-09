package com.cardekho.car_catalog.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    private Long id;
    private String model;
    private Integer year;
    private String color;
    private Double price;
    private String fuelType;
    private String transmission;
    private Long brandId;
    private Long manufacturerId;
}
