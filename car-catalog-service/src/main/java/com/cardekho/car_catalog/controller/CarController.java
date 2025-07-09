package com.cardekho.car_catalog.controller;

import com.cardekho.car_catalog.model.Car;
import com.cardekho.car_catalog.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Car updatedCar = carService.updateCar(id, carDetails);
        return updatedCar != null ? ResponseEntity.ok(updatedCar) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
