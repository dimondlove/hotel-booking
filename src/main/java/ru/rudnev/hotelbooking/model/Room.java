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
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private Booking booking;

    private Boolean isBooking;

    public Room(Long id, String title, String description, Hotel hotel, Boolean isBooking) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.hotel = hotel;
        this.isBooking = isBooking;
    }

    public RoomDto convertToDto() {
        return new RoomDto(this.id, this.title, this.description, this.hotel, this.isBooking);
    }
}
