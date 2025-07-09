package com.cardekho.booking.controller;

import com.cardekho.booking.model.Booking;
import com.cardekho.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<Booking> confirmBooking(
            @PathVariable Long id,
            @RequestParam String paymentId) {
        return ResponseEntity.ok(bookingService.confirmBooking(id, paymentId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }
}
