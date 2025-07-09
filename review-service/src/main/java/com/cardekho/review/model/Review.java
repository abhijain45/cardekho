package com.cardekho.review.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    private String id;
    private Long userId;
    private Long carId;
    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;
    private boolean approved;
}
