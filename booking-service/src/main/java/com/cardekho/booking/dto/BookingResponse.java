package com.cardekho.booking.dto;

import com.cardekho.booking.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long id;
    private Long userId;
    private Long carId;
    private LocalDateTime bookingDate;
    private LocalDateTime deliveryDate;
    private String status;
    private String color;
    private String engineType;
    
    public static BookingResponse fromEntity(Booking booking) {
        return new BookingResponse(
            booking.getId(),
            booking.getUserId(),
            booking.getCarId(),
            booking.getBookingDate(),
            booking.getDeliveryDate(),
            booking.getStatus(),
            booking.getColor(),
            booking.getEngineType()
        );
    }
}
