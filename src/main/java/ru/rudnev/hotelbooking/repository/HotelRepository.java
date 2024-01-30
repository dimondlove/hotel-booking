package ru.rudnev.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rudnev.hotelbooking.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
