package ru.rudnev.hotelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.model.Hotel;
import ru.rudnev.hotelbooking.model.Room;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    private Long id;

    private String title;

    private String address;

    private String description;

    private Collection<Room> rooms;

    public Hotel convertToHotel() {
        return new Hotel(this.id, this.title, this.address, this.description, this.rooms);
    }
}
