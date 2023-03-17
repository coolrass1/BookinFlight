package com.skk.Seating_arrangement_system.seatflight;

import com.skk.Seating_arrangement_system.seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seatflight")
public class SeatflightController {

    @Autowired
    SeatFlightService seatFlightService;

    @PostMapping("/create")

    Seatflight createSeat(@RequestBody Seatflight seat){
        System.out.println(seat);

        return seatFlightService.CreateSeat(seat);




    }
}
