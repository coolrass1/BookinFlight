package com.skk.Seating_arrangement_system.seatflight;

import com.skk.Seating_arrangement_system.bookingflight.Bookingflight;
import com.skk.Seating_arrangement_system.student.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seatflight {
    @Id
    @SequenceGenerator(
            name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seat_sequence"
    )
    private Long Id;






    private  String  seatnumber;

    @OneToOne(
            mappedBy = "reserved_seat"
    )

private Bookingflight bookingflight;
    private boolean isbooked;
}
