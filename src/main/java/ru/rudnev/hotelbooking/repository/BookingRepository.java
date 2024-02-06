package ru.rudnev.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rudnev.hotelbooking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
