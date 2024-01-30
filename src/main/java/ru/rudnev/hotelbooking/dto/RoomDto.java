package ru.rudnev.hotelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.model.Hotel;
import ru.rudnev.hotelbooking.model.Room;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Long id;

    private String title;

    private String description;

    private Hotel hotel;

    public Room convertToRoom() {
        return new Room(this.id, this.title, this.description, this.hotel);
    }
}
