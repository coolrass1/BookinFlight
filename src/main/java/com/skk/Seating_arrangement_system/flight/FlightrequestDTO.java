package com.skk.Seating_arrangement_system.flight;


import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightrequestDTO {

    private String flightnumber;

    @NotBlank(message = "Depart name cannot be  DTO blank")


    private String depart;

    @NotEmpty(message="arrival required")
    private String arrival;

    private Date departime;

    private  Date arrivaltime;
    private int seatavailable;
    private boolean isFullyBooked;
}
