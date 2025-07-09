package com.cardekho.car_catalog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String model;
    private Integer year;
    private String color;
    private Double price;
    private String fuelType;
    private String transmission;
    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
