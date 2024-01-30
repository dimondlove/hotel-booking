package ru.rudnev.hotelbooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.dto.RoomDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Hotel hotel;

    public RoomDto convertToDto() {
        return new RoomDto(this.id, this.title, this.description, this.hotel);
    }
}
