package com.cardekho.review.dto;

import com.cardekho.review.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private String id;
    private Long userId;
    private Long carId;
    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;
    private boolean approved;
    
    public static ReviewResponse fromEntity(Review review) {
        return new ReviewResponse(
            review.getId(),
            review.getUserId(),
            review.getCarId(),
            review.getRating(),
            review.getComment(),
            review.getReviewDate(),
            review.isApproved()
        );
    }
}
