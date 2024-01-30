package ru.rudnev.hotelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.model.Hotel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    private Long id;

    private String title;

    private String description;

    public Hotel convertToHotel() {
        return new Hotel(this.id, this.title, this.description);
    }
}
