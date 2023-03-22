package com.skk.Seating_arrangement_system.flight;


import jakarta.persistence.*;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {
    @jakarta.persistence.Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )
    private Long Id ;
    private String flightnumber;

    @NotBlank(message = "Depart name cannot be blank")

    private String depart;
    private String arrival;

    private Date departime;

    private  Date arrivaltime;
    private int seatavailable;
    private boolean isFullyBooked;
    /*
    @JsonIgnore
    @OneToMany(mappedBy ="flightid_id")
    List<Bookingflight> bookingflights;*/


}
