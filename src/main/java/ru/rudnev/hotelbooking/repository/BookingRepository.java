package ru.rudnev.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rudnev.hotelbooking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
