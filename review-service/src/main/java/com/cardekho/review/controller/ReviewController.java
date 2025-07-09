package com.cardekho.review.controller;

import com.cardekho.review.model.Review;
import com.cardekho.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<Review>> getReviewsForCar(@PathVariable Long carId) {
        return ResponseEntity.ok(reviewService.getReviewsForCar(carId));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Review> approveReview(@PathVariable String id) {
        return ResponseEntity.ok(reviewService.approveReview(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
