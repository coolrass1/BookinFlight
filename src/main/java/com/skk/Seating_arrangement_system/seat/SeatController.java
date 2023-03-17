package com.skk.Seating_arrangement_system.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")

public class SeatController {
    @Autowired
    SeatService seatService;

    @PostMapping("/create")
    public Seat createSeat(@RequestBody Seat seat){
        System.out.println(seat);

       return seatService.CreateSeat(seat);



    }
    @PostMapping("/booking")
    public  Seat Booking(@RequestBody Booking booking){
        System.out.println(booking.getEmail());
       // return null;

        return  seatService.ReserveSeat(booking.getNumber(), booking.getEmail());
    }
}
