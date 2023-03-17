package com.skk.Seating_arrangement_system.bookingflight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository flightRepository;


    List<Bookingflight> getAllbookings(){
        return flightRepository.findAll();
    }

    public Bookingflight createBooking(Bookingflight bookinflighy) {

        bookinflighy.setConfirm(true);

        return flightRepository.save(bookinflighy);
    }
}
