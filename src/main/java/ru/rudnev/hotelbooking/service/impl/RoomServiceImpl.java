package ru.rudnev.hotelbooking.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.hotelbooking.dto.RoomDto;
import ru.rudnev.hotelbooking.model.Hotel;
import ru.rudnev.hotelbooking.model.Room;
import ru.rudnev.hotelbooking.repository.HotelRepository;
import ru.rudnev.hotelbooking.repository.RoomRepository;
import ru.rudnev.hotelbooking.service.RoomService;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public Collection<RoomDto> getAllRooms() {
        Collection<Room> rooms = roomRepository.findAll();
        return rooms
                .stream()
                .map(Room::convertToDto)
                .toList();
    }

    @Override
    public Collection<RoomDto> getAllHotelRooms(Long hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        return hotel.get().getRooms().stream().map(Room::convertToDto).toList();
    }

    @Override
    public RoomDto addRoom() {
        return new RoomDto();
    }

    @Override
    public RoomDto addHotelRoom(Long hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        Room room = new Room();
        room.setIsBooking(false);
        room.setHotel(hotel.get());
        return room.convertToDto();
    }

    @Override
    public void saveRoom(RoomDto roomDto) {
        roomRepository.save(roomDto.convertToRoom());
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
