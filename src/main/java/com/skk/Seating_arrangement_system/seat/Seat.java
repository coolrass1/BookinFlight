package com.skk.Seating_arrangement_system.seat;

import com.skk.Seating_arrangement_system.student.Student;
import com.skk.Seating_arrangement_system.student.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
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

    @OneToOne(
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY,
            optional = true
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "Id",
            nullable = false
    )

    private User user;

    @Column(unique = true)
    private  Long seatnumber;


    private boolean isbooked;
}
