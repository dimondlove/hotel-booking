package ru.rudnev.hotelbooking.service;

import ru.rudnev.hotelbooking.dto.BookingDto;

import java.util.Collection;

public interface BookingService {
    Collection<BookingDto> getAllBookings();

    BookingDto addBookingRoom(Long roomId);

    void saveBooking(BookingDto bookingDto);
}
