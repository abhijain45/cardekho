package com.cardekho.review.service;

import com.cardekho.review.model.Review;
import com.cardekho.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    
    public Review createReview(Review review) {
        review.setReviewDate(LocalDateTime.now());
        review.setApproved(false); // Needs moderation by default
        return reviewRepository.save(review);
    }
    
    public List<Review> getReviewsForCar(Long carId) {
        return reviewRepository.findByCarIdAndApproved(carId, true);
    }
    
    public Review approveReview(String id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.setApproved(true);
        return reviewRepository.save(review);
    }
    
    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }
}
