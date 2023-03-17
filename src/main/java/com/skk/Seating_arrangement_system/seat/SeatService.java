package com.skk.Seating_arrangement_system.seat;

import com.skk.Seating_arrangement_system.student.Student;
import com.skk.Seating_arrangement_system.student.StudentRepository;
import com.skk.Seating_arrangement_system.student.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private StudentRepository studentRepository;


    public Seat CreateSeat(Seat seat){
        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        seat.setUser(author);

        return seatRepository.save(seat);
    }

    public Seat ReserveSeat( Long number, String email){

        Seat seat_to_reserved = seatRepository.findBySeatnumber(number);
        if (seat_to_reserved.isIsbooked()) return null;

        Student student = studentRepository.findByUsername(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));


        seat_to_reserved.setIsbooked(true);
        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        seat_to_reserved.setUser(author);

        seatRepository.save(seat_to_reserved);
        student.setBookedseat(true);
        student.setSeat(seat_to_reserved.getSeatnumber());
        studentRepository.save(student);
        return seat_to_reserved;





    }

}
