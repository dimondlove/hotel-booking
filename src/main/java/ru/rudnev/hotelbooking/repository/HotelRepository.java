package ru.rudnev.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rudnev.hotelbooking.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
