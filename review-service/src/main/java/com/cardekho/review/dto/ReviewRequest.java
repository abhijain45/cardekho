package com.cardekho.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @NotNull
    private Long userId;
    
    @NotNull
    private Long carId;
    
    @Min(1)
    @Max(5)
    private Integer rating;
    
    private String comment;
}
