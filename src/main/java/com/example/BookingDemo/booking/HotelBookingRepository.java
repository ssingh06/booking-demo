package com.example.BookingDemo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
    List<HotelBooking> findByRatePerNightLessThan(double price);
    List<HotelBooking> findByRatePerNightGreaterThan(double price);
}
