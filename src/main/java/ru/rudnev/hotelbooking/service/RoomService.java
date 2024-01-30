package ru.rudnev.hotelbooking.service;

import ru.rudnev.hotelbooking.dto.HotelDto;
import ru.rudnev.hotelbooking.dto.RoomDto;

import java.util.Collection;

public interface RoomService {
    Collection<RoomDto> getAllRooms();

    Collection<RoomDto> getAllHotelRooms(Long hotelId);

    RoomDto addRoom();

    RoomDto addHotelRoom(Long hotelId);

    void saveRoom(RoomDto roomDto);

    RoomDto editRoom(Long id);

    void deleteRoom(Long id);
}
