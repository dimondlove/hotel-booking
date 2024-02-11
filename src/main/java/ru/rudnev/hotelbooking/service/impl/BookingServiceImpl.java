package ru.rudnev.hotelbooking.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.hotelbooking.dto.BookingDto;
import ru.rudnev.hotelbooking.model.Booking;
import ru.rudnev.hotelbooking.model.Room;
import ru.rudnev.hotelbooking.repository.BookingRepository;
import ru.rudnev.hotelbooking.repository.RoomRepository;
import ru.rudnev.hotelbooking.service.BookingService;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    @Override
    public Collection<BookingDto> getAllBookings() {
        Collection<Booking> bookings = bookingRepository.findAll();
        return bookings
                .stream()
                .map(Booking::convertToDto)
                .toList();
    }

    @Override
    public BookingDto addBookingRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        Booking booking = new Booking();
        booking.setRoom(room.get());
        return booking.convertToDto();
    }

    @Override
    public void saveBooking(BookingDto bookingDto) {
        bookingRepository.save(bookingDto.convertToBooking());
    }
}
