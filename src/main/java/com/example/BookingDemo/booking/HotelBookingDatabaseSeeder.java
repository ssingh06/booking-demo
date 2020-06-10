package com.example.BookingDemo.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to initialize the Hotel Bookings database on the application startup. Since it implements the
 * {@link CommandLineRunner} interface, the run method implemented here is executed after all the application beans are
 * created and the application context is created. This provides a way to initialize the app, set initial states on
 * startup.
 */
@Component
public class HotelBookingDatabaseSeeder implements CommandLineRunner {
    private final HotelBookingRepository hotelBookingRepository;

    @Autowired
    public HotelBookingDatabaseSeeder(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        final List<HotelBooking> bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Customer1", "Marriot", 75, 2));
        bookings.add(new HotelBooking("Customer2", "Ibis", 50, 4));
        bookings.add(new HotelBooking("Customer3", "Novotel", 60, 1));
        hotelBookingRepository.saveAll(bookings);
    }
}
