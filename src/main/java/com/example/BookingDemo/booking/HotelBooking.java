package com.example.BookingDemo.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents the hotel booking object. This class also uses the @Entity annotation since this represents
 * the data that is persisted in the database.
 */
@Entity
public class HotelBooking implements Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private final String customerName;
    private final String hotelName;
    private final double ratePerNight;
    private final int numberOfNights;

    /**
     * A default constructor is needed by the Spring framework for any class annotated with @Entity.
     */
    public HotelBooking() {
        this.customerName = "None";
        this.hotelName = "None";
        this.ratePerNight = 0;
        this.numberOfNights = 0;
    }

    public HotelBooking(String customerName, String hotelName, double ratePerNight, int numberOfNights) {
        this.customerName = customerName;
        this.hotelName = hotelName;
        this.ratePerNight = ratePerNight;
        this.numberOfNights = numberOfNights;
    }

    /**
     * Getter for id.
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Getter for customer name.
     * @return customer name.
     */
    @Override
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Getter for hotel name.
     * @return hotel name.
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Getter for rate per night.
     * @return rate per night.
     */
    public double getRatePerNight() {
        return ratePerNight;
    }

    /**
     * Getter for number of nights in hotel booking.
     * @return number of nights.
     */
    public int getNumberOfNights() {
        return numberOfNights;
    }

    /**
     * Getter for total price of the hotel booking.
     * @return total price.
     */
    @Override
    public double getTotalPrice() {
        return ratePerNight * numberOfNights;
    }
}
