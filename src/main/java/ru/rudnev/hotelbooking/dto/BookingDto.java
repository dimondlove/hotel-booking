package ru.rudnev.hotelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.model.Booking;
import ru.rudnev.hotelbooking.model.Room;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;

    private String name;

    private String surname;

    private String dateOfBooking;

    private String dateOfEntry;

    private String dateOfDeparture;

    private Room room;

    public Booking convertToBooking() {
        return new Booking(this.id, this.name, this.surname, this.dateOfBooking, this.dateOfEntry, this.dateOfDeparture, this.room);
    }
}
