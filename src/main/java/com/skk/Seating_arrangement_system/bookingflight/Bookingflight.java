package com.skk.Seating_arrangement_system.bookingflight;

import com.skk.Seating_arrangement_system.flight.Flight;
import com.skk.Seating_arrangement_system.seatflight.Seatflight;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Bookingflight {
    @jakarta.persistence.Id
    @SequenceGenerator(
            name = "bookflight_sequence",
            sequenceName = "bookflight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bookflight_sequence"
    )
    private Long Id ;
    /*private String flightnumber;

    private String depart;
    private String arrival;

    private Date departime;
    private  Date arrivaltime;*/
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "flightid_id",
            referencedColumnName = "Id"
    )

    private  Flight flight;
    private String username;
    private String Address;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "flightseat_id",
            referencedColumnName = "Id"
    )
    private Seatflight reserved_seat;
    private boolean isConfirm;

    public Bookingflight(String username, boolean confirm, Seatflight reservedSeat) {

        this.username=username;
        this.isConfirm=confirm;
        this.reserved_seat=reservedSeat;
    }
}
