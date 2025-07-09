package com.cardekho.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private Long userId;
    private Long carId;
    private String deliveryAddress;
    private String color;
    private String engineType;
}
