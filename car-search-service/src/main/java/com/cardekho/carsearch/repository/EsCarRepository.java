package com.cardekho.carsearch.repository;

import com.cardekho.carsearch.model.EsCar;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsCarRepository extends ElasticsearchRepository<EsCar, String> {
    List<EsCar> findByModelContaining(String model);
    List<EsCar> findByBrandId(Long brandId);
    List<EsCar> findByPriceBetween(Double minPrice, Double maxPrice);
}
