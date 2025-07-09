package com.cardekho.carsearch.controller;

import com.cardekho.carsearch.model.EsCar;
import com.cardekho.carsearch.repository.EsCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search/cars")
@RequiredArgsConstructor
public class CarSearchController {
    private final EsCarRepository esCarRepository;

    @GetMapping
    public List<EsCar> searchCars(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        
        if (query != null) {
            return esCarRepository.findByModelContaining(query);
        } else if (brandId != null) {
            return esCarRepository.findByBrandId(brandId);
        } else if (minPrice != null && maxPrice != null) {
            return esCarRepository.findByPriceBetween(minPrice, maxPrice);
        }
        
        return (List<EsCar>) esCarRepository.findAll();
    }
}
