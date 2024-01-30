package ru.rudnev.hotelbooking.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.hotelbooking.dto.HotelDto;
import ru.rudnev.hotelbooking.model.Hotel;
import ru.rudnev.hotelbooking.repository.HotelRepository;
import ru.rudnev.hotelbooking.service.HotelService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Collection<HotelDto> getAllHotels() {
        Collection<Hotel> hotels = hotelRepository.findAll();
        return hotels
                .stream()
                .map(Hotel::convertToDto)
                .toList();
    }

    @Override
    public HotelDto addHotel() {
        return new HotelDto();
    }

    @Override
    public void saveHotel(HotelDto hotelDto) {
        hotelRepository.save(hotelDto.convertToHotel());
    }

    @Override
    public HotelDto editHotel(Long id) {
        return hotelRepository.findById(id).get().convertToDto();
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
