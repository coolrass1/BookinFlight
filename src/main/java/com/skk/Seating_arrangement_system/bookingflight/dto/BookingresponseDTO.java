package com.skk.Seating_arrangement_system.bookingflight.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class BookingresponseDTO  {

    private String Bookingnumber;

    public String clientname;
    public String clientaddress;
    public String flightname;
    @NotBlank
    public String depart;

    public String arrival;
    private String seat;


}
