package com.skk.Seating_arrangement_system.bookingflight;

import com.skk.Seating_arrangement_system.bookingflight.dto.BookingRequestDTO;
import com.skk.Seating_arrangement_system.bookingflight.dto.BookingresponseDTO;
import com.skk.Seating_arrangement_system.exception.EmployeeNotFoundException;
import com.skk.Seating_arrangement_system.flight.Flight;
import com.skk.Seating_arrangement_system.flight.FlightService;
import com.skk.Seating_arrangement_system.seatflight.SeatFlightService;
import com.skk.Seating_arrangement_system.seatflight.Seatflight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flight")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private FlightService flightService;
    @Autowired
    SeatFlightService seatFlightService;

    @GetMapping("/booking")
    List <BookingresponseDTO> getaalFlight(){
        System.out.println(bookingService.getAllbookings());



       return  bookingService.getAllbookings().stream().map((s->    BookingresponseDTO.builder()
                .clientaddress(s.getAddress())
               .Bookingnumber(s.getId().toString())
               .clientname(s.getUsername())
               .depart(s.getFlight().getDepart())
               .flightname(s.getFlight().getFlightnumber())
               .arrival(s.getFlight().getArrival())
               .seat(s.getReserved_seat().getSeatnumber())
                .build())).collect(Collectors.toList());



    }

    @PostMapping("/booking")
    @Transactional
    Bookingflight createBooking(@RequestBody BookingRequestDTO bookingRequestDTO){

        Flight flightoreserved= flightService.findFlight(bookingRequestDTO.getId());
        if (flightoreserved.getSeatavailable()<1 ) throw  new EmployeeNotFoundException("Flight is fully Booked");

        //get All seats not booked
        List available_seats = seatFlightService.Allbooked();


        if (available_seats.size()==0)  throw  new EmployeeNotFoundException("not found seat");
        Seatflight seat=(Seatflight) available_seats.get(0);

      //Booking a seat
       Seatflight bookedseat= seatFlightService.UpdateSeat(seat.getId(), seat);

        flightoreserved.setId(bookingRequestDTO.getId());


        Bookingflight bookingflight= Bookingflight.builder()
                .flight(flightoreserved)
                .Address(bookingRequestDTO.getAddress())
                .username(bookingRequestDTO.getUsername())
                .reserved_seat(bookedseat)

                .build();

       available_seats.clear();
flightoreserved.setSeatavailable(flightoreserved.getSeatavailable()-1);
 flightService.createFlight(flightoreserved);

        return bookingService.createBooking(bookingflight);
    }

}
