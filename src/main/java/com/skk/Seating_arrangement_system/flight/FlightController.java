package com.skk.Seating_arrangement_system.flight;

import jakarta.validation.Valid;
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

    /*@PostMapping("/create")
    Flight createFlight(@RequestBody Flight  flight){


        return flightService.createFlight(flight);
    }*/

    @PostMapping("/create")
    Flight createFlight(@RequestBody @Valid FlightrequestDTO flightrequestDTO){


        return flightService.createFlight(flightrequestDTO);
    }

}
