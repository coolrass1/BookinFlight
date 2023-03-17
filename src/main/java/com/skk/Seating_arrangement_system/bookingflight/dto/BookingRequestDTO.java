package com.skk.Seating_arrangement_system.bookingflight.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component

public class BookingRequestDTO {

    private Long Id;
    private String username;
    private String address;

}
