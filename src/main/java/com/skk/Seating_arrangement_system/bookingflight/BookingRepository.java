package com.skk.Seating_arrangement_system.bookingflight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookingflight, Long> {

}
