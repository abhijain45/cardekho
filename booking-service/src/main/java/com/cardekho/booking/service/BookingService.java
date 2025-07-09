package com.cardekho.booking.service;

import com.cardekho.booking.model.Booking;
import com.cardekho.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    
    public Booking createBooking(Booking booking) {
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("PENDING");
        return bookingRepository.save(booking);
    }
    
    public Booking confirmBooking(Long id, String paymentId) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setStatus("CONFIRMED");
        booking.setPaymentId(paymentId);
        return bookingRepository.save(booking);
    }
    
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    
    public Booking cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }
}
