package ru.rudnev.hotelbooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.dto.BookingDto;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String name;

    private String surname;

    private String dateOfBooking;

    private String dateOfEntry;

    private String dateOfDeparture;

    @OneToOne(fetch = FetchType.LAZY)
    private Room room;

    public BookingDto convertToDto() {
        return new BookingDto(this.id, this.name, this.surname, this.dateOfBooking, this.dateOfEntry, this.dateOfDeparture, this.room);
    }
}
