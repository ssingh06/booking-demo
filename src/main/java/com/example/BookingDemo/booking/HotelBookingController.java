package com.example.BookingDemo.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This is the rest controller handling requests for hotel bookings.
 */
@RestController
@RequestMapping("/bookings")
public class HotelBookingController {
    private final HotelBookingRepository hotelBookingRepository;

    @Autowired
    public HotelBookingController(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    /**
     * Get the list of all hotel bookings.
     * API: /bookings/all
     *
     * @return All bookings.
     */
    @RequestMapping("/all")
    public List<HotelBooking> getAll() {
        return hotelBookingRepository.findAll();
    }

    /**
     * Get all hotel bookings greater than a certain price point.
     * API: /bookings/affordable/{price}
     *
     * @param price price to compare against.
     * @return All bookings less than a certain price point.
     */
    @RequestMapping("/affordable/{price}")
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return hotelBookingRepository.findByRatePerNightLessThan(price);
    }

    /**
     * Get all hotel bookings greater than a certain price point.
     * API: /bookings/differentiated/{price}
     *
     * @param price price to compare against.
     * @return All bookings greater than a certain price point.
     */
    @RequestMapping("/differentiated/{price}")
    public List<HotelBooking> getDifferentiated(@PathVariable double price) {
        return hotelBookingRepository.findByRatePerNightGreaterThan(price);
    }

    /**
     * Create a new hotel booking.
     * API: /bookings/create
     *
     * @param hotelBooking request body containing hotel booking fields.
     * @return the new hotel booking object.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public HotelBooking create(@RequestBody HotelBooking hotelBooking) {
        hotelBookingRepository.save(hotelBooking);
        return hotelBooking;
    }

    /**
     * Get hotel booking by id.
     * API: /bookings/booking/{id}
     *
     * @param id id of the hotel booking record.
     * @return hotel booking
     */
    @RequestMapping("booking/{id}")
    public Optional<HotelBooking> getById(@PathVariable long id) {
        return hotelBookingRepository.findById(id);
    }

    /**
     * Delete hotel booking by id.
     * API: /bookings/booking/{id}
     *
     * @param id id of the hotel booking record.
     */
    @RequestMapping(value = "booking/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable long id) {
        hotelBookingRepository.deleteById(id);
    }
}
