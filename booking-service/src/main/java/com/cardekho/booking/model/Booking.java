package com.cardekho.booking.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long carId;
    private LocalDateTime bookingDate;
    private LocalDateTime deliveryDate;
    private String deliveryAddress;
    private String status; // PENDING, CONFIRMED, CANCELLED, COMPLETED
    private String paymentId;
    private Double totalAmount;
    private String color;
    private String engineType;
}
