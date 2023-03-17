package com.skk.Seating_arrangement_system.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/list")
    List <Flight> getaalFlight(){
        return flightService.getAllflight();

    }

    @PostMapping("/create")
    Flight createFlight(@RequestBody Flight  flight){
        System.out.println(flight.getDepart());

        return flightService.createFlight(flight);
    }

}
