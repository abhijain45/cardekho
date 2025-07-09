package com.cardekho.car_catalog.service;

import com.cardekho.car_catalog.model.Car;
import com.cardekho.car_catalog.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }
    
    public Car createCar(Car car) {
        return carRepository.save(car);
    }
    
    public Car updateCar(Long id, Car carDetails) {
        Car car = getCarById(id);
        if (car != null) {
            // Update car properties
            return carRepository.save(car);
        }
        return null;
    }
    
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
