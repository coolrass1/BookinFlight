package com.skk.Seating_arrangement_system.flight;

import com.skk.Seating_arrangement_system.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository  flightRepository;


    List<Flight> getAllflight(){
        return flightRepository.findAll();
    }

    public Flight createFlight(Flight flight) {
        System.out.println(flight);
        return flightRepository.save(flight);
    }

    public Flight findFlight(Long flightnumberid) {

        return flightRepository.findById(flightnumberid) .orElseThrow(() -> new EmployeeNotFoundException("Flight not found"));
    }
}
