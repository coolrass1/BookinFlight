package com.skk.Seating_arrangement_system.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByIsbooked(boolean st);
    Seat findBySeatnumber (Long  number );
}
