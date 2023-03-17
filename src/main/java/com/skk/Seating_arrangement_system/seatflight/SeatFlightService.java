package com.skk.Seating_arrangement_system.seatflight;

import com.skk.Seating_arrangement_system.exception.EmployeeNotFoundException;
import com.skk.Seating_arrangement_system.student.Student;
import com.skk.Seating_arrangement_system.student.StudentRepository;
import com.skk.Seating_arrangement_system.student.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatFlightService {

    @Autowired
    private SeatFlightRepository seatRepository;
    @Autowired
    private StudentRepository studentRepository;


    public Seatflight CreateSeat(Seatflight seat){


        return seatRepository.save(seat);
    }

    public List<Seatflight> Allbooked(){
        return seatRepository.findByIsbooked(false);

    }



    public Seatflight UpdateSeat(Long Id, Seatflight seat){


        var seatoupdate =seatRepository.findById(Id).orElseThrow(() -> new EmployeeNotFoundException(Id));

        seatoupdate.setIsbooked(true);
        return seatRepository.save(seatoupdate);
    }
    public List<Seatflight> getAllseatflights(){
        return seatRepository.findAll();
    }

    public Seatflight ReserveSeat(Long number, String email){


return null;




    }

}
