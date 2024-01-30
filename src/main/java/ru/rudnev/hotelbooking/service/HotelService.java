package ru.rudnev.hotelbooking.service;

import ru.rudnev.hotelbooking.dto.HotelDto;

import java.util.Collection;

public interface HotelService {
    Collection<HotelDto> getAllHotels();

    HotelDto addHotel();

    void saveHotel(HotelDto hotelDto);

    HotelDto editHotel(Long id);

    void deleteHotel(Long id);
}
