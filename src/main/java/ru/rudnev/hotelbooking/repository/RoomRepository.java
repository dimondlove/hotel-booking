package ru.rudnev.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rudnev.hotelbooking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
