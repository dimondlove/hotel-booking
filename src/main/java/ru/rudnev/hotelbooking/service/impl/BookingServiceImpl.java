package ru.rudnev.hotelbooking.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.hotelbooking.dto.BookingDto;
import ru.rudnev.hotelbooking.model.Booking;
import ru.rudnev.hotelbooking.model.Room;
import ru.rudnev.hotelbooking.repository.BookingRepository;
import ru.rudnev.hotelbooking.repository.RoomRepository;
import ru.rudnev.hotelbooking.service.BookingService;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
        booking.setDateOfBooking(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        booking.setRoom(room.get());
        room.get().setIsBooking(true);
        roomRepository.save(room.get());

        return booking.convertToDto();
    }

    @Override
    public void saveBooking(BookingDto bookingDto) {
        bookingRepository.save(bookingDto.convertToBooking());
    }

    @Override
    public void deleteBooking(Long id) {
        Long idRoom = bookingRepository.findById(id).get().getRoom().getId();
        bookingRepository.deleteById(id);
        Optional<Room> room = roomRepository.findById(idRoom);
        room.get().setIsBooking(false);
        roomRepository.save(room.get());
    }
}
