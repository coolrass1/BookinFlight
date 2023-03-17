package com.skk.Seating_arrangement_system.seatflight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatFlightRepository extends JpaRepository<Seatflight,Long> {
    List<Seatflight> findByIsbooked(boolean st);
    Seatflight findBySeatnumber (Long  number );
}
