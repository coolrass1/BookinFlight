package com.skk.Seating_arrangement_system.flight;

import com.skk.Seating_arrangement_system.student.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  FlightRepository extends JpaRepository<Flight, Long> {
//    Optional<Flight> findByFlightnumber(Long id);


}
