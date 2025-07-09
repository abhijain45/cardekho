package com.cardekho.review.repository;

import com.cardekho.review.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByCarId(Long carId);
    List<Review> findByUserId(Long userId);
    List<Review> findByCarIdAndApproved(Long carId, boolean approved);
}
