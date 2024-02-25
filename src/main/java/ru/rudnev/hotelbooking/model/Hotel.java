package ru.rudnev.hotelbooking.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.dto.HotelDto;

import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(unique = true)
    private String title;

    private String address;

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Room> rooms;

    public Hotel(Long id, String title, String address, String description, Collection<Room> rooms) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.description = description;
        this.rooms = rooms;
    }

    public HotelDto convertToDto() {
        return new HotelDto(this.id, this.title, this.address, this.description, this.rooms);
    }
}
